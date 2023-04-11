package ru.job4j.collection;

import java.util.*;

import static java.util.Comparator.naturalOrder;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            StringJoiner start = new StringJoiner("/");
            for (String el : value.split("/")) {
                tmp.add(start.add(el).toString());
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
