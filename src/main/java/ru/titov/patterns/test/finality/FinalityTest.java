package ru.titov.patterns.test.finality;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 18:55
 **/
public class FinalityTest {
    private static final String test = "test done";

    public static void test() throws Throwable {
        List<Throwable> t = new ArrayList<>();

        try {
            throw new Exception("first message");
        } catch (Exception ex) {
            t.add(ex);
            Exception second = new Exception("second Exception");
            t.add(second);
            throw second;
        } finally {

            Exception exception = new Exception("Finaly error");
            t.stream().forEach(throwable -> exception.addSuppressed(throwable));

            throw exception;

        }
    }
}
