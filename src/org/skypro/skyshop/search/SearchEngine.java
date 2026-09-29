package org.skypro.skyshop.search;

import org.skypro.skyshop.Exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searchList = new HashSet<>(); // ← вот так
    Set<Searchable> results = new TreeSet<>(new Comparator<Searchable>(){
        @Override
        public int compare(Searchable e1, Searchable e2) {
            int nameLenghtCompare = Integer.compare(e2.getName().length(), e1.getName().length());
            if (nameLenghtCompare != 0) {
                return nameLenghtCompare;
            }
            return e1.getName().compareTo(e2.getName());
        }

    });



    public Set<Searchable> search(String searchQuery){
        results.clear();
        System.out.println("Результаты поиска по: " + searchQuery);
        for (Searchable e: searchList) {
            Searchable element = e;
            if (element != null) {
                if (element.getSearchTerm().toLowerCase().contains(searchQuery.toLowerCase())) {
                    results.add(element);
                }
            }
        }
        int count = 1;
        for (Searchable set: results){
            System.out.println(count + ") " + set.getName() + " " + set.getContent());
            count++;
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

        for (Searchable e: searchList){
            Searchable element = e;
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
