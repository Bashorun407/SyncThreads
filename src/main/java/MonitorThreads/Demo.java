package MonitorThreads;

public class Demo {
    //this class demonstrates how threads get notified by a notifier
    public static void main(String[] args) {
        //object of message class
        Message message = new Message(" process this message.");
        Reader reader1 = new Reader(message);
        new Thread(reader1, "READER-1").start();

        Reader reader2 = new Reader(message);
        new Thread(reader2, "READER-2").start();

        //creating a notifier object
        Notifier notifier = new Notifier(message);
        new Thread(notifier, "NOTIFIER").start();

        System.out.println(" All the threads are started.");
    }
}
