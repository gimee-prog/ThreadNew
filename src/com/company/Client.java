package com.company;

import com.company.FrontSystem;
import java.util.Random;

public class  Client extends Thread {
    int clientId;
    Random random = new Random();
    FrontSystem fs;
    public Client(int clientId, FrontSystem fs) {
        this.clientId = clientId;
        this.fs = fs;
    }

    @Override
    public void run() {

        try {

            fs.addRequest(new Request(clientId,"clientThreadName = Клиент№" + clientId, random.nextInt(10000), random.nextInt(2)));

           // Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
