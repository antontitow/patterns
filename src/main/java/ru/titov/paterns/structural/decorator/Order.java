package ru.titov.paterns.structural.decorator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 0:21
 **/
public class Order implements Summator {
    private Double car;
    private Map<String, Double> additional;

    public Order(Double car, Map<String, Double> additional) {
        this.car = car;
        this.additional = additional;
    }

    @Override
    public Double sum() {
        AtomicReference<Double> allPosition = new AtomicReference<>(car);
        additional.values().stream().forEach(cost -> allPosition.set(allPosition.get() + cost));

        return allPosition.get();
    }
}
