package AtomicOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//this class demonstrates how to use atomic increment or otherwise for thread-safe operations aside
//synchronized method or synchronized block
public class AtomicDemo {
    //class variable
    private static AtomicInteger counter = new AtomicInteger(0);

    //this is the main method where all operations take place for this package
    public static void main(String[] args) throws InterruptedException {
        //this is a list of threads
        List<Thread> allThreads = new ArrayList<>();
        //total number of increment that will be performed by all the threads
        int totalCounts = 10000;

        //using a for loop to create, add threads to thread list and start each thread created
        for (int i = 0; i < totalCounts; i++){
            //each time a new thread is created, increment function increases count
            var t = new Thread(AtomicDemo::increment);
            //allThread list adds each new thread to the list
            allThreads.add(t);
            //each new thread starts execution
            t.start();
        }

        //for loop to make each thread 'join' the main method after execution
        for (Thread thread : allThreads){
            thread.join();
        }

        System.out.println(counter);
        System.out.println(" exiting the main method....");
    }

    //class method
    public static void increment(){
        //here counter uses a method of atomicinteger to perform thread-safe increment
        counter.incrementAndGet();
    }
}
