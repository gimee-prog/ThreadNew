package com.company;

import com.company.FrontSystem;
import java.util.Random;

public class  Client extends Thread {
    int clientId;
    Random random = new Random();
    FrontSystem fs = new FrontSystem();
    public Client(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try {
            System.out.println("Клиент №"+clientId+": Заявка №" + clientId + " отправлена в банк");
            fs.addRequest(new Request(clientId,"clientThreadName = Клиент№" + clientId, random.nextInt(10000), random.nextInt(2)));

           // Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
