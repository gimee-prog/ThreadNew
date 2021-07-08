package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class FrontSystem {

   volatile static ArrayDeque<Request> requestQueue = new ArrayDeque<>();

    public synchronized void addRequest(Request request) throws InterruptedException {
        while (requestQueue.size() == 2){
            wait();
        }
        requestQueue.addFirst(request);
        System.out.println("Клиент №"+request.getId()+":Заявка №"+request.getId()+" принята банком" + "{" +request.getName()+ ", сумма= " +request.getAmount()+" , тип операции: " + request.getRequestType());
          //  System.out.println();
        notify();

    }
    public  synchronized Request getRequest() throws InterruptedException {
        while (requestQueue.size() == 0){
            wait();
           // notifyAll();
        }
        notify();
     return requestQueue.removeLast();
    }
}
