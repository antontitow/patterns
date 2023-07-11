package ru.titov.paterns.creation.prototype;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 2:14
 **/
@Data
@NoArgsConstructor
public class DemoPrototype implements Clonable {
    private String one = "ONE";
    private String two = "two";
    private String author = "Tony";
    private String address = "SomeCity";

    @Override
    public Clonable copy() {
        return new DemoPrototype();
    }
}
