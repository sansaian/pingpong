package _concarent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

    Sharedresource sharedresource = new Sharedresource();
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Main main = new Main();
        PingPong pingPong1 = new PingPong(main.sharedresource, "ping", 1, main.lock);
        PingPong pingPong2 = new PingPong(main.sharedresource, "pong", 2, main.lock);
        Thread thread1 = new Thread(pingPong1);
        Thread thread2 = new Thread(pingPong2);
        thread1.start();
        try {
            Thread.currentThread().sleep(130);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        main.printWord();

    }


    private void printWord() {
        while (!Thread.currentThread().isInterrupted()) {
            try {

                lock.lock();
                if (!sharedresource.isRead()) {
                    System.out.println(sharedresource.getSayword());
                    sharedresource.setRead(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                lock.unlock();
            }

        }
    }

}


