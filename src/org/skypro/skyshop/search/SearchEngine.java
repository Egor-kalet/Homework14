package org.skypro.skyshop.search;

import org.skypro.skyshop.Exceptions.BestResultNotFound;

import java.util.LinkedList;

public class SearchEngine {

    private LinkedList<Searchable> searchList = new LinkedList<>(); // ← вот так



    public LinkedList<Searchable> search(String searchQuery){
        System.out.println("Результаты поиска по: " + searchQuery);
        int count = 0;
        LinkedList<Searchable> results = new LinkedList<>();
        for (int i = 0; i < searchList.size(); i++){
            Searchable element = searchList.get(i);
            if (element != null){
                if (element.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase())){
                    results.add(element);
                    System.out.println((count + 1) + ") " + results.get(count).toString());
                    count++;
                }
            }
        }
        return results;
    }

    public void add(Searchable element){

        if (element != null){
            searchList.add(element);
        }
    }

    public Searchable getSearchTerm(String searchQuery){
        int count1 = 0;
        int count2 = 0;
        int index = 0;
        Searchable maxSuitable = null;

        for (int i = 0; i < searchList.size(); i++){
            Searchable element = searchList.get(i);
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
