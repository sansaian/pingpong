package _concarent;
/**
 * Created by Maxim on 26.12.2016.
 */
public class Sharedresource {


    private volatile String sayword = "";
    private volatile boolean read = true;
    private volatile int numberLastThread = 0;

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getNumberLastThread() {
        return numberLastThread;
    }

    public void setNumberLastThread(int numberLastThread) {
        this.numberLastThread = numberLastThread;
    }

    public String getSayword() {
        return sayword;
    }

    public void setSayword(String sayword) {
        this.sayword = sayword;
    }
}
