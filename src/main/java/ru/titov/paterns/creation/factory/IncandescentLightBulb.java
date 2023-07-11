package ru.titov.paterns.creation.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 1:51
 **/
@Slf4j
public class IncandescentLightBulb extends Bulb{
    @Override
    public void shine() {
        log.info("Светит лампа накаливания");
    }
}
