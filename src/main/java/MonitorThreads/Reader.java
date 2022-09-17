package MonitorThreads;

public class Reader implements Runnable{

    private Message message;

    //class constructor
    public Reader(Message m){
        this.message = m;
    }

    //implementing the run method of the Runnable interface

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (message){

            try{
                System.out.println(name +
                        " waiting to be  notified at this time: " +
                        System.currentTimeMillis());
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " waiter thread got notified at this time: " + System.currentTimeMillis());
        System.out.println(name + " processed Notifier: " +  message.getMessage());
    }
}
