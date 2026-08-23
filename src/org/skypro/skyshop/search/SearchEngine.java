package org.skypro.skyshop.search;

public class SearchEngine {

    private Searchable[] searchList;

    public SearchEngine(int leng) {
        this.searchList = new Searchable[leng];
    }

    public Searchable[] search(String searchQuery){
        System.out.println("Результаты поиска по: " + searchQuery);
        int count = 0;
        Searchable[] results = new Searchable[searchList.length];
        for (int i = 0; i < searchList.length; i++){
            Searchable element = searchList[i];
            if (element.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase())){
                results[count] = element;
                System.out.println((count + 1) + ") " + results[count].toString());
                count++;
                if (count == 5){
                    break;
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
}
