package ch.hslu.ad.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task.class);

    private static int numberOfCounts = 0;
    private static Long sleepTime = 5L;

    public static void main(String[] args) throws InterruptedException {
        task(1);
        task(2);
        task(3);
        task(5);
        task(10);
        task(11);
        task(15);
        task(100);
        task(101);
    }
    public static void task(final int n) throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        numberOfCounts = 0;

        task1(); task1(); task1(); task1();

        for(int i = 0; i < n; i++){
            task2(); task2(); task2();
            for(int j = 0; j < n; j++){
                task3(); task3(); task3();
            }
        }

        Long endTime = System.currentTimeMillis();
        Long elapsedTime = endTime - startTime;

        LOGGER.info("N="+ n + "-; number of Steps " + numberOfCounts + "; Elapsed Time: " + elapsedTime + "ms;");
    }

    public static void task1() throws InterruptedException {
        Thread.sleep(sleepTime);
        numberOfCounts++;
    }
    public static void task2() throws InterruptedException {
        Thread.sleep(sleepTime);
        numberOfCounts++;
    }
    public static void task3()throws InterruptedException{
        Thread.sleep(sleepTime);
        numberOfCounts++;
    }
}
