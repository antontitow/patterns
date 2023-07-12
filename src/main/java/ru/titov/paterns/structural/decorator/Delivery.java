package ru.titov.paterns.structural.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 0:29
 **/
@Slf4j
public class Delivery implements Summator {
    Summator summator;
    Double costDelivery = 200.00;

    public Delivery(Summator summator, Double costDelivery) {
        this.summator = summator;
        this.costDelivery = costDelivery;
    }

    public Delivery(Summator summator) {
        this.summator = summator;
    }

    @Override
    public Double sum() {
        return summator.sum() + costDelivery;
    }
}
