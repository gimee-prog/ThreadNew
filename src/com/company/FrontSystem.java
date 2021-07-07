package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class FrontSystem {

   volatile static ArrayDeque<Request> requestQueue = new ArrayDeque<>(2);

    public synchronized void addRequest(Request request) throws InterruptedException {
        if (requestQueue.size() == 2){
            wait();
            notifyAll();
        } else {
        requestQueue.addFirst(request);
            System.out.println("Заявка №"+request.getId()+" принята банком" + "{" +request.getName()+ ", сумма= " +request.getAmount()+" , тип операции: " + request.getRequestType());
        }

    }
    public  synchronized Request getRequest() throws InterruptedException {
        if (requestQueue.size() == 0){
            Thread.sleep(5000);
            notifyAll();
        }

     return requestQueue.removeLast();
    }
}
