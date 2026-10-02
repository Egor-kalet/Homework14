package org.skypro.skyshop.search;

import java.util.function.Predicate;

public class containsSearchQuery implements Predicate<Searchable> {
    private String query;

    public containsSearchQuery(String query) {
        this.query = query;
    }

    @Override
    public boolean test(Searchable o) {
        return o.getSearchTerm().toLowerCase().contains(query.toLowerCase());
    }

}
