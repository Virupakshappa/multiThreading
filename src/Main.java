import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore a = new Semaphore(1);  // first thread is allowed to run immediately
        Semaphore b = new Semaphore(0); // second thread has to wait


        Runnable ht = new HosaThread(a,b);
        Runnable hlt = new HaleThread(b,a);

        Thread t1 = new Thread(ht);
        Thread t2 = new Thread(hlt);

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}