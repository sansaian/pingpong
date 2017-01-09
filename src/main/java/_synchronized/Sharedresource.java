package _synchronized;

/**
 * Created by Maxim on 26.12.2016.
 */
public class Sharedresource {


    private String sayword = "";
    private boolean read = true;
    private int numberLastThread = 0;

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
