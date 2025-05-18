package org.skypro.skyshop.articles;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    String getSearchableName();

    default String getStringRepresentation() {
        return getSearchableName() + " — тип " + getContentType();
    }
}