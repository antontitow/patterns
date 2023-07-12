package ru.titov.paterns.structural.bridge;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 1:45
 **/
public abstract class AbstractLaundry {
    private Iron ironer;

    public abstract void wash(String linen);
}
