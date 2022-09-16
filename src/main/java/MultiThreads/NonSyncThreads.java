package MultiThreads;

import java.util.ArrayList;
import java.util.List;

//this class creates 10000 threads to display the effects of non-synchronization of threads
//this may not be the best way to execute this exercise...just to check the possibility of a lock/data loss
public class NonSyncThreads {
    //this count is a class variable
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {

        //a list data type that stores threads
        List<Thread> allThreads = new ArrayList<>();
        int numberOfIncrement = 10000;

        //loop to create a 10000 threads and starting each thread once created
        for (int i = 0; i < numberOfIncrement; i++){
            //creating new threads with each iteration
            var t = new Thread( NonSyncThreads::increaseCounts); //each new thread increments the count variable
            allThreads.add(t); //each new thread is added to the list
            t.start();//starts the thread
        }

        //loop to join each thread in the allThreads list to the main after executing
        for (Thread thread : allThreads){
            thread.join();
        }

//        this statement displays the result of count after all threads must have executed.
//        the answer may not always be 10000...due to synchronization errors

        System.out.println(count);

    }

    // static method to increment the value of count
    public static void increaseCounts (){
        count++;
    }
}
