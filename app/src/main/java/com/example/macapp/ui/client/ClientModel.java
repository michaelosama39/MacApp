package com.example.macapp.ui.client;

public class ClientModel {
    private String name , number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ClientModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public ClientModel() {

    }
}
