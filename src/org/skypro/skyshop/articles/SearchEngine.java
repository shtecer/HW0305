package org.skypro.skyshop.articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new ArrayList<>();
        //        searchableItems = new Searchable[size];
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

//    public List<Searchable> search(String term) {
//        List<Searchable> results = new ArrayList<>();
public Map<String, Searchable> search(String term) {
    Map<String, Searchable> resultsMap = new TreeMap<>();
        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().contains(term)) {
//                results.add(item);
                resultsMap.put(item.getSearchableName(), item);
            }
        }
        return resultsMap;
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