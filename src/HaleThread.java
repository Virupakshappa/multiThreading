import java.util.concurrent.Semaphore;

public class HaleThread implements Runnable{

    int[] hale = {1,2,3};
    Semaphore ins, outs;



    public HaleThread(Semaphore ins, Semaphore outs) {
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
            System.out.println("HoleThread... " +i);
            outs.release();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }

    }
}
