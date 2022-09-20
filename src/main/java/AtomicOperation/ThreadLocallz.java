package AtomicOperation;

import java.util.concurrent.TimeUnit;

//this class demonstrates the use of ThreadLocal functionality for resource sharing with threads.
//each thread keeps its version of the static variable without interfaring with the others value
public class ThreadLocallz implements Runnable{

    //private static ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(()->"hello");
    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    //main method
    public static void main(String[] args) {
        ThreadLocallz runThread = new ThreadLocallz();

        var thread1 = new Thread(runThread);
        var thread2 = new Thread(runThread);

        //starting the two threads
        thread1.start();
        thread2.start();

    }
    //implementing run method of the Runnable interface

    @Override
    public void run() {
        integerThreadLocal.set((int)(Math.random() * 100));
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integerThreadLocal.get());
    }
}
