package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FrontSystem fs = new FrontSystem();
        BackSystem bs = new BackSystem();


        for (int i = 0; i < 5; i++) {
            new Client(i, fs).start();
        }

        new Treatment(1, fs, bs).start();
        new Treatment(2, fs, bs).start();

    }
}
