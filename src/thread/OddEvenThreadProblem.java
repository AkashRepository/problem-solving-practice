package thread;

public class OddEvenThreadProblem {


    public static void main(String[] args) {
        //char a = 'a', b = 'b';
        // sout ababababa n times
        int n = 10;
        Lock arr = new Lock('b');
        Thread t1 = new Thread(new ThreadImpl('a', n, arr), "T1");
        Thread t2 = new Thread(new ThreadImpl('b', n, arr), "T2");
        t1.start();
        t2.start();
    }

    static class Lock {
        Character c;

        public Lock(Character c) {
            this.c = c;
        }
    }


    static class ThreadImpl implements Runnable {

        private Character c;
        private Lock lock;
        private int n;
        private int counter = 0;

        public ThreadImpl(Character c, int n, Lock lock) {
            this.c = c;
            this.n = n;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (counter++ < n) {
                synchronized (lock) {
                    while (lock.c == c) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + this.c);
                    lock.c = c;
                    lock.notify();
                }
            }
        }
    }

}
