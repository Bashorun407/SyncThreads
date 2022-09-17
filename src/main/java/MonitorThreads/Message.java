package MonitorThreads;

public class Message {
    private String message;

    //class constructor
    public  Message(String m){
        this.message = m;
    }

    //gets message
    public String getMessage() {
        return message;
    }

    //sets message to a new message
    public void setMessage(String message) {
        this.message = message;
    }
}
