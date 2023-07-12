package ru.titov.paterns.common;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 22:48
 **/

/**
 * Immutable object
 */
public final class Range {

    private static LinkedHashSet<Integer> ranges = new LinkedHashSet<>();

    public Range(LinkedHashSet<Integer> setRanges) {

        ranges = setRanges.stream().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public LinkedHashSet<Integer> getRanges() {
        return ranges.stream().collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
