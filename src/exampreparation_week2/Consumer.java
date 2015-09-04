/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampreparation_week2;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author LukaszKrawczyk
 */
public class Consumer implements Runnable {

    long totalSum = 0;
    BlockingQueue<Long> s2;

    public Consumer(BlockingQueue<Long> s2) {
        this.s2 = s2;
    }

    @Override
    public void run() {
        long tal3 = 0;

        while (true) {
            try {
                tal3 = s2.take();
                totalSum += tal3;
            } catch (InterruptedException ex) {
                break;
            }

            System.out.println("Temp: " + tal3);
        }
    }

    public long getTotalSum() {
        return totalSum;
    }

}
