package com.company;

public class Main {
    public static void main(String[] args){
        FrontSystem fs = new FrontSystem();
        BackSystem bs = new BackSystem();
        new Client(1, fs, 5000, "CREDIT").start();
        new Client(2, fs, 6000, "PAYMENT").start();
        new Client(3, fs, 7000, "CREDIT").start();
        new Client(4, fs, 500, "PAYMENT").start();
        new Client(5, fs, 9000, "CREDIT").start();

        new Treatment(1, fs, bs).start();
        new Treatment(2, fs, bs).start();

    }
}
