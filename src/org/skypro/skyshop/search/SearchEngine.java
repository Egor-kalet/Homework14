package org.skypro.skyshop.search;

import org.skypro.skyshop.BestResultNotFound;

import java.util.Arrays;

public class SearchEngine {

    private Searchable[] searchList;

    public SearchEngine(int leng) {
        this.searchList = new Searchable[leng];
    }

    public Searchable[] search(String searchQuery){
        System.out.println("Результаты поиска по: " + searchQuery);
        int count = 0;
        Searchable[] results = new Searchable[5];
        for (int i = 0; i < searchList.length; i++){
            Searchable element = searchList[i];
            if (element != null){
                if (element.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase())){
                    results[count] = element;
                    System.out.println((count + 1) + ") " + results[count].toString());
                    count++;
                    if (count == 5){
                        break;
                    }
                }
            }
        }
        return results;
    }

    public void add(Searchable elements){

        if (elements != null){
            for (int i = 0; i < searchList.length; i++){
                if (searchList[i] == null){
                    searchList[i] = elements;
                    break;
                }
            }
        }
    }

    public Searchable getSearchTerm(String searchQuery){
        int count1 = 0;
        int count2 = 0;
        int index = 0;
        Searchable maxSuitable = null;
        for (int i = 0; i < searchList.length; i++){
            Searchable element = searchList[i];
            if (element != null){
                if (element.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase())){


                    while ((index = element.getName().indexOf(searchQuery, index)) != -1){
                        count2++;
                        index += searchQuery.length();
                    }
                    index = 0;
                    while ((index = element.getContent().indexOf(searchQuery, index)) != -1){
                        count2++;
                        index += searchQuery.length();
                    }
                    if (count1 < count2){
                        maxSuitable = element;
                        index = 0;
                        count1 = count2;
                        count2 = 0;
                    }
                    count2 = 0;
                }
            }
        }
        if (count1 == 0){
            throw new BestResultNotFound();
        }
        return maxSuitable;
    }

}
