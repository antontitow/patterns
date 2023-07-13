package ru.titov.patterns.structural.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 2:01
 **/
@Slf4j
public class ManualLaundress extends AbstractLaundry {
    private Iron iron;

    public ManualLaundress(Iron iron) {
        this.iron = iron;
    }

    @Override
    public void wash(String linen) {
        log.info("{} было постирано вручную", linen);
        iron.ironed();
    }
}
