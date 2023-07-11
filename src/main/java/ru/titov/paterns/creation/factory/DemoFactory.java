package ru.titov.paterns.creation.factory;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 1:43
 **/
public class DemoFactory {
    public Bulb getBuld(DemoType bulbType) {
        switch (bulbType) {
            case DIODE -> {
                return new DiodeBulb();
            }
            case GLOWING -> {
                return new IncandescentLightBulb();
            }
            default -> {
                return null;
            }
        }
    }
}
