package ru.titov.patterns.test.pecs;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 17:02
 **/
@Slf4j
@NoArgsConstructor
public class Child extends Parent {

    public void takeMany(List<? super Child> childList) {
//        childList.add(new Top());
//        childList.add(new Parent());
//        childList.add(new Child());
//        childList.add(new Grandson());
        Parent top = (Parent) childList.get(0);
        log.info("takeMany");
        log.info(childList.get(0).getClass().toString());

        log.info(childList.toString());
    }


}
