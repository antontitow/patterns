package ru.titov.patterns.creation.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 12.07.2023, 2:03
 **/
@Slf4j
public class DemoB {
    private String name;
    private String surname;

    public DemoB(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public static class DemoBBuilder{
        private String name;
        private String surname;

        public DemoBBuilder setName(String name){
            this.name = name;
            return this;
        }

        public DemoBBuilder setSurname(String surname){
            this.surname = surname;
            return this;
        }

        public DemoB build(){
            return new DemoB(this.name,this.surname);
        }

    }
}
