package com.company;

public class Treatment extends Thread{
     int id;
     FrontSystem fs;
     Request request;
    BackSystem bs ;
    public Treatment(int id, FrontSystem fs, BackSystem bs ){
        this.id = id;
        this.fs = fs;
        this.bs = bs;
    }
    @Override
    public void run() {
        while (true) {
            try {
                request = fs.getRequest();
                System.out.println("Обработчик №" + id + ": Заявка получена на обработку по клиенту №" + request.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assert request != null;
           bs.treatmentRequest(request);
        }
    }
}
