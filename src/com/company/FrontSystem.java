package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FrontSystem {

   volatile static Deque<Request> requestQueue = new LinkedList<>();

    public synchronized void addRequest(Request request) throws InterruptedException {
        while (requestQueue.size() == 2){
            wait();
        }
        requestQueue.addFirst(request);
        System.out.println("Клиент №"+request.getId()+":Заявка №"+request.getId()+" принята банком" + "{" +request.getName()+ ", сумма= " +request.getAmount()+" , тип операции: " + request.getRequestType());
        notifyAll();
    }
    public  synchronized Request getRequest() throws InterruptedException {
        while (requestQueue.size() == 0){
            wait();
        }
        notifyAll();
     return requestQueue.removeLast();
    }
}
