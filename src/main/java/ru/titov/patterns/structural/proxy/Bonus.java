package ru.titov.patterns.structural.proxy;

import lombok.extern.slf4j.Slf4j;
import ru.titov.patterns.common.Range;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 22:45
 **/
@Slf4j
public class Bonus implements Computer {
    {
        log.info("Bonus create");
    }

    LinkedHashSet allRanges = Stream.of(1, 10, 100, 10000).collect(Collectors.toCollection(LinkedHashSet::new));
    Range range = new Range(allRanges);

    @Override
    public Integer proccessBonus(Double sum) {
        log.info("invoke Bonus.proccessBonus()");

        LinkedHashSet<Integer> range1 = range.getRanges();
        range1.add(sum.intValue());
        LinkedHashSet<Integer> range2 = range.getRanges();
        log.info(range1.toString());
        log.info(range2.toString());

        long length = range1.size() - 1;
        return range1.stream().skip(length).findFirst().get();
    }
}
