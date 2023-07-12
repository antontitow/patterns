package ru.titov.paterns.structural.adapter;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 23:59
 **/
@Slf4j
@Builder
public class Postman {
    private String name;

    public Postman(String name) {
        this.name = name;
    }

    public void callPostman(String address) {
        log.info("invoke postman {} for send letter to {}", name, address);
    }
}
