package com.company;

public class BackSystem extends Thread {
    int treatmentId;
    private static volatile int balance=10000;


    public void treatmentRequest(Request request) {

        if (request.getRequestType() == "CREDIT"){
            if (balance < request.getAmount()){
                System.out.println( "Заявка №"+request.getId()+": не выполнена. " +
                        "На счету банка недостаточно средств. Баланс банка= " + balance);
                return;
            } else {
                balance -= request.getAmount();
                System.out.println(" Заявка №"+request.getId()+": выполнена. Баланс банка= "+balance);
            }
        }
        if (request.getRequestType() == "PAYMENT"){
            balance += request.getAmount();
            System.out.println("Заявка №"+request.getId()+": выполнена. Баланс банка= "+balance);
        }

    }
}
