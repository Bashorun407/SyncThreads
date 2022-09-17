package MonitorThreads;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable {

    private Message message;

    //class constructor
    public Notifier(Message m){
        this.message = m;
    }

    //implementing the run method of the Runnable interface

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started at this time: " + System.currentTimeMillis());

        try{
            synchronized (message){
                TimeUnit.MILLISECONDS.sleep(100);
                message.setMessage(" Notifier work done.");
                //message.notify();
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Notifier finished work.");
    }
}
