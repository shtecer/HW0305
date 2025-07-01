package org.skypro.skyshop.articles;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }


public Set<Searchable> search(String term) {
    return searchableItems.stream()
            .filter(item -> item != null && item.getSearchTerm().contains(term))
            .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public class SearchableComparator implements Comparator<Searchable> {

        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthCompare = Integer.compare(s2.getSearchableName().length(), s1.getSearchableName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.getSearchableName().compareTo(s2.getSearchableName());
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable item : searchableItems) {
            if (item != null) {
                int currentCount = countOccurrences(item.getSearchTerm(), search);
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    bestMatch = item;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Нет подходящего результата: " + search);
        }
        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}