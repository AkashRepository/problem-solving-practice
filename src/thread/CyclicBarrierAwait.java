package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierAwait {

    public static void main(String[] args) {

        CyclicBarrierAwait runner = new CyclicBarrierAwait();
        runner.run();
    }

    private void run() {
        List<Integer> distances = Collections.synchronizedList(new ArrayList<>());

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new BarrierPointRunner(distances));
        Random random = new Random();


        for (int j = 1; j <= 5; j++) {

            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + " adding numbers : ");

                for (int i = 0; i < 5; i++) {
                    int randomNum = random.nextInt(5);
                    System.out.print(randomNum + " ");
                    distances.add(randomNum);
                }

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }, "Thread [" + j + "]").start();
        }

    }

    class BarrierPointRunner implements Runnable {

        private final List<Integer> distances;

        BarrierPointRunner(List<Integer> distances) {
            this.distances = distances;
        }

        @Override
        public void run() {
            System.out.println("Total of all the values is : " + distances.stream().reduce(0, Integer::sum));
            System.exit(-1);
        }
    }

}
