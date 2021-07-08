package com.company;

public class Request {
    private int id;
    private String name;
    private  int amount;
    private String requestType;

    public  Request(int id, String name, int amount, String requestType) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.requestType = requestType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getRequestType() {
        return requestType;
    }
}
