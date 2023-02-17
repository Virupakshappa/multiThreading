import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore a = new Semaphore(1);  // first thread is allowed to run immediately
        Semaphore b = new Semaphore(0); // second thread has to wait


        HosaThread ht = new HosaThread(a,b);
        HaleThread hlt = new HaleThread(b,a);
        ht.start();
        hlt.start();
        try {
            ht.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            hlt.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}