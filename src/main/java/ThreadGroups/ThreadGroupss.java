package ThreadGroups;

import java.util.concurrent.TimeUnit;

public class ThreadGroupss {

    //this program displays how thread groups operate
    public static void main(String[] args) throws InterruptedException {

        //creating a threadGroup
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup1");
        //creating thread objects
        var t0 = new Thread(threadGroup, ThreadGroupss::execute);
        var t1 = new Thread(threadGroup, ThreadGroupss::execute);
        var t2 = new Thread(threadGroup, ThreadGroupss::execute);
        var t3 = new Thread(threadGroup, ThreadGroupss::execute);
        var t4 = new Thread(threadGroup, ThreadGroupss::execute);

        //starting each thread
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //interrupting all the threads by interrupting the group
        TimeUnit.SECONDS.sleep(2);
        threadGroup.interrupt();

        System.out.println("exiting the main program");

    }

    public static void execute(){
        //infinite while loop
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(800);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
