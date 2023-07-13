package ru.titov.patterns.structural.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 2:02
 **/
@Slf4j
public class AutoIron implements Iron {
    @Override
    public void ironed() {
        log.info("Поглажено автоматически");
    }
}
