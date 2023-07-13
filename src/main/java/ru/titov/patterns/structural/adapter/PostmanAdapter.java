package ru.titov.patterns.structural.adapter;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 13.07.2023, 0:12
 **/
public class PostmanAdapter implements Sender {
    private Postman postman;

    public PostmanAdapter(Postman postman) {
        this.postman = postman;
    }


    @Override
    public void send(String address) {
        postman.callPostman(address);
    }
}
