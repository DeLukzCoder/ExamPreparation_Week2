/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampreparation_week2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author LukaszKrawczyk
 */
public class ExamPreparation_Week2 {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        executeThreads(3);

        long endTime = System.nanoTime();

        System.out.println("Time: " + (endTime - startTime));

    }

    public static void executeThreads(int amountRunning) {
        long[] tal1 = {4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42};

        BlockingQueue<Long> s1 = new ArrayBlockingQueue(tal1.length);
        BlockingQueue<Long> s2 = new ArrayBlockingQueue(tal1.length);

        for (int i = 0; i < tal1.length; i++) {
            try {
                s1.put(tal1[i]);
            } catch (InterruptedException ex) {

            }
        }

        Consumer con1 = new Consumer(s2);
        Thread tc1 = new Thread(con1);
        tc1.start();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < amountRunning; i++) {
            executor.execute(new Producer("t" + i, s1, s2));
        }
        executor.shutdown();

        while (!executor.isTerminated()) {

        }
        tc1.interrupt();

        System.out.println("Total Sum: " + con1.getTotalSum());
    }

}
