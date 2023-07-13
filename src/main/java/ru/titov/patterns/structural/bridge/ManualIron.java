package ru.titov.patterns.structural.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 2:03
 **/
@Slf4j
public class ManualIron implements Iron {
    @Override
    public void ironed() {
        log.info("Поглажено вручную сортудником1");
    }
}
