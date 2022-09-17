package MultiThreads;

import java.util.ArrayList;
import java.util.List;

//this program displays how synchronized threads operate
public class SynchronizedThreads {

    // a static variable
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //a list which contains threads
        List<Thread> allThreads = new ArrayList<>();
        //total number of threads to be created
        int noOfThreads = 10000;

        //for loop to create 10000 threads
        for (int i = 0; i < noOfThreads; i++){
            //new thread being created with each iteration
            var t = new Thread(SynchronizedThreads::increaseCounts); //each new thread increments the counter variable
            allThreads.add(t); //thread is added to the allThreads list
            t.start(); //thread starts executing
        }

        //for loop to join each thread to the main after executing
        for (Thread thread : allThreads){
            thread.join();
        }

        System.out.println(count);
    }

    // either of the following methods can be called by the class in each new thread created to produce the same result
    //a static method ensures synchronized increment of count
    public static synchronized void increaseCounts(){
        count++;
    }

    // this static method also ensures synchronized increment of count
    public static void increaseCountWithSyncBlock(){
        synchronized (SynchronizedThreads.class){
            count++;
        }
    }
}
