package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Client(i).start();
        }
        for (int i = 0; i < 10; i++) {
            new Client(i).join();
        }
        new BackSystem(1).start();
        new BackSystem(2).start();

    }
}
