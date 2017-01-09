package _synchronized;

/**
 * Created by Maxim on 26.12.2016.
 */
public class Main {

    Sharedresource sharedresource = new Sharedresource();

    public static void main(String[] args) {

        Main main = new Main();
        PingPong pingPong1 = new PingPong(main.sharedresource, "ping", 1);
        PingPong pingPong2 = new PingPong(main.sharedresource, "pong", 2);
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


    public void printWord() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (sharedresource) {
                if(!sharedresource.isRead()){
                    System.out.println(sharedresource.getSayword());
                    sharedresource.setRead(true);
               }
                    sharedresource.notifyAll();
            }
        }

    }

}
