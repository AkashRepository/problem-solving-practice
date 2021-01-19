import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

class RangeLock {

    int n;
    volatile ConcurrentHashMap<String, ReentrantLock> m;

    public RangeLock(int n) {
        this.n = n;
        m = new ConcurrentHashMap<>();
    }


    public void rUnlock(int str, int end) {
        ReentrantLock reentrantLock = m.get(str + "-" + end);
        Boolean[] arr =new Boolean[34];
        Arrays.stream(arr).filter(s -> s).count();
        if (reentrantLock != null){
            System.out.println("Releasing lock for "+str+" : "+end);
            reentrantLock.unlock();
//            m.put(str + "-" + end, null);
        }
    }

    public void rLock(int str, int end) {
        if (str > n || end > n)
            throw new IllegalArgumentException();

        synchronized (m) {
            boolean f = true;
            ReentrantLock o = null;
            while (f) {
                for (String s : m.keySet()) {
                    List<Integer> split = Arrays.stream(s.split("-")).map(Integer::parseInt).collect(Collectors.toList());
                    if (!(str < split.get(0) && end <= split.get(0)) || str >= split.get(1) && end > split.get(1)) {
                        o = m.get(s);
                        if(o==null)break;
                    }
                }
                if (o==null || !o.isLocked()) {
                    System.out.println("Acquiring lock for " + str + " : " + end);
                    ReentrantLock reentrantLock = new ReentrantLock();
                    reentrantLock.lock();
                    m.put(str + "-" + end, reentrantLock);
                    f = false;
                } else {
                    System.out.println("Waiting for "+str+" : "+end);
                }
            }

        }

    }
}

public class ArrayRangeLocking {


    public static void main(String[] args) {
        RangeLock lock = new RangeLock(10);
        new Thread(() -> {
            lock.rLock(2,5);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.rUnlock(2,5);
        }).start();
        new Thread(() -> {
            lock.rLock(3,4);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.rUnlock(3,4);
        }).start();
        new Thread(() -> {
            lock.rLock(7,10);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.rUnlock(7,10);
        }).start();
        new Thread(() -> {
            lock.rLock(6,7);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.rUnlock(6,7);
        }).start();
        new Thread(() -> {
            lock.rLock(5,10);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.rUnlock(5,10);
        }).start();
    }
}
