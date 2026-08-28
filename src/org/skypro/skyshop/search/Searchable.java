package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getName();

    String getContentType();

    default String getStringRepresentation(){
        return getName() + " — " + getContentType();
    }
}
