package _concarent;
import _concarent.Sharedresource;

import java.util.concurrent.locks.Lock;

public class PingPong implements Runnable {
    private Sharedresource sharedresource;
    private final String WORD;
    private final int PINGPONGINT;
    private Lock lock;

    public PingPong(Sharedresource sharedresource, String word, int pingpongInt, Lock lock) {

        this.sharedresource = sharedresource;
        this.WORD = word;
        this.PINGPONGINT = pingpongInt;
        this.lock = lock;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {

                lock.lock();
                    if (sharedresource.isRead() && sharedresource.getNumberLastThread() != PINGPONGINT) {
                        sharedresource.setSayword(WORD);
                        sharedresource.setNumberLastThread(PINGPONGINT);
                        sharedresource.setRead(false);
                    }

            } catch (Exception e) {
                e.printStackTrace();
            }finally{

                lock.unlock();
            }
        }


    }
}
