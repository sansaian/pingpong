package _synchronized;

class PingPong implements Runnable {
    private Sharedresource sharedresource;
    private final String WORD;
    private final int PINGPONGINT;

    public PingPong(Sharedresource sharedresource, String word, int pingpongInt) {

        this.sharedresource = sharedresource;
        this.WORD = word;
        this.PINGPONGINT = pingpongInt;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (sharedresource) {
                    if (sharedresource.isRead() && sharedresource.getNumberLastThread() != PINGPONGINT) {
                        sharedresource.setSayword(WORD);
                        sharedresource.setNumberLastThread(PINGPONGINT);
                        sharedresource.setRead(false);
                    }
                    sharedresource.notify();
                    sharedresource.wait();

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
