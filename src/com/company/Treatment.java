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
        while (!FrontSystem.requestQueue.isEmpty()) {
            try {
                request = fs.getRequest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Обработчик №" + id + ": Заявка получена на обработку по клиенту №" + request.getId());
            assert request != null;
           bs.treatmentRequest(request);
        }
    }
}
