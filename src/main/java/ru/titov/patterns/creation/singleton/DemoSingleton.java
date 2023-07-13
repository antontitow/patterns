package ru.titov.patterns.creation.singleton;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 1:41
 **/
public class DemoSingleton {
    private static DemoSingleton instance;

    private DemoSingleton() {
    }

    public static DemoSingleton getInstance() {
        if (instance == null) {
            instance = new DemoSingleton();
        }

        return instance;
    }
}
