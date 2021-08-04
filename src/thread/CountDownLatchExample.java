package thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i=1;i<=5;i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+ " processing...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }, "Thread ["+i+"]").start();
        }

        System.out.println("Waiting for all child threads to finish up...");
        countDownLatch.await();
        System.out.println("All are done...");
    }
}
