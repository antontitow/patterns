package ru.titov.paterns.structural.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 1:48
 **/
@Slf4j
public class AutoLaundress extends AbstractLaundry {
    private Iron iron;

    public AutoLaundress(Iron iron) {
        this.iron = iron;
    }

    @Override
    public void wash(String linen) {
        log.info("{} было постирано автоматически", linen);
        iron.ironed();
    }
}
