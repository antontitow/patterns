package ru.titov.patterns.test.pecs;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 17:01
 **/
@Slf4j
@NoArgsConstructor
public class Parent extends Top {

    public void takeAll(List<? extends Parent> parents) {
        Top top = parents.get(0);
        Parent parent = parents.get(0);
        Child child = (Child) parents.get(0);
        Grandson grandson = (Grandson) parents.get(0);
        log.info(parents.toString());
    }


}
