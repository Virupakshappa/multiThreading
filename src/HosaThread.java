import java.util.concurrent.Semaphore;

public class HosaThread implements  Runnable{

    int[] hosa = {1,2,3};
    Semaphore ins, outs;


     HosaThread(Semaphore ins, Semaphore outs) {
        this.ins = ins;
        this.outs = outs;
    }

    public void run(){


        for(int i=1; i<5; i++){
            try {
                ins.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("HosaThread... " +i);
            outs.release();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}
