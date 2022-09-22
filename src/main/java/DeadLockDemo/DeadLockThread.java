package DeadLockDemo;

import java.util.concurrent.TimeUnit;

//this class demonstrates how DeadLocks operates
public class DeadLockThread {

    //static class variables of the object type as locks
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

        //instantiating the first thread, synchronizing lock operations and starting it
        new Thread(
                ()->{
                    synchronized (lock1){
                        System.out.println("lock1 captured by thread-1");
                        try{
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                           //e.printStackTrace();
                        }
                    }

                    //this code will never be executed
                    synchronized (lock2){
                        System.out.println("DeadLock: lock2 capture will never be executed by thread-1");
                    }
                }
        ).start();

        //instantiating the second thread, synchronizing its access to lock and starting it
        new Thread(
                ()->{
                    synchronized (lock2){
                        //I intentionally left the time out so that this thread can capture lock2 to create DeadLock
                        System.out.println("Lock2 captured by thread-2");
                    }

                    //this block will never be executed because of DeadLock...since lock1 has already been captured by...
                    //...thread-1
                    synchronized (lock1){
                        System.out.println("DeadLock: lock1 will never be captured by thread-2");
                    }
                }
        ).start();
    }
}
