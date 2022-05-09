package ru.geekbrains.lesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private CyclicBarrier barrier;
    private CountDownLatch start;
    private CountDownLatch finish;
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(CyclicBarrier barrier, CountDownLatch start, CountDownLatch finish, Race race, int speed) {
        this.barrier = barrier;
        this.start = start;
        this.finish = finish;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            start.countDown();
            barrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            try {
                race.getStages().get(i).sem.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            race.getStages().get(i).go(this);
            race.getStages().get(i).sem.release();
        }
        if (MainClass.atomicInt.getAndIncrement() == 0) {
            System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победил " + name);
        }
        finish.countDown();
    }
}
