package com.company;

import java.util.Random;

public class  Client extends Thread {
    int clientId;
    Random random = new Random();
    FrontSystem fs;
    int amount;
    String type;
    public Client(int clientId, FrontSystem fs, int amount, String type) {
        this.clientId = clientId;
        this.fs = fs;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            fs.addRequest(new Request(clientId,"clientThreadName = Клиент№" + clientId, amount, type));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
