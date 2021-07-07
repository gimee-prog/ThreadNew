package com.company;

public class BackSystem extends Thread {
    int treatmentId;
    private static volatile int balance=0;
    FrontSystem fs = new FrontSystem();
    public BackSystem(int id){
        this.treatmentId = id;
    }
    @Override
    public void run() {
        Request backRequest = null;
        try {
            backRequest = fs.getRequest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert backRequest != null;
        if (backRequest.getRequestType() == 0){
            if (balance < backRequest.getAmount()){
                System.out.println("Обработчик №" + treatmentId +": Заявка №"+backRequest.getId()+" не выполнена. " +
                        "На счету банка недостаточно средств. Баланс банка= " + balance);
                return;
            } else {
                balance += backRequest.getAmount();
                System.out.println("Обработчик №" + treatmentId +": Заявка №"+backRequest.getId()+" выполнена. Баланс банка= "+balance);
            }
        }
        if (backRequest.getRequestType() == 1){
            balance += backRequest.getAmount();
            System.out.println("Обработчик №" + treatmentId +": Заявка №"+backRequest.getId()+" выполнена. Баланс банка= "+balance);


        }

    }
}
