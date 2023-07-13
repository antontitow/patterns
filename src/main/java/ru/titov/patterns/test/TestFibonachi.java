package ru.titov.patterns.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 11:25
 **/
@Slf4j
public class TestFibonachi {
    public void getList(Integer number) {
        int first = 0;
        int second = 1;
        List<Integer> fibonachi = new ArrayList<>();
        fibonachi.add(first);
        int temp;

        for (; number > second; ) {
            temp = first;
            fibonachi.add(second);
            first = second;
            second = second + temp;
        }

        log.info(fibonachi.toString());
    }

    public boolean getResult(boolean a, boolean b) {
        //упростить (a && b) || b
        return b;
    }
}
