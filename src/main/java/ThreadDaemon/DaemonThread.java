package ThreadDaemon;

import java.util.concurrent.TimeUnit;

public class DaemonThread {

    //this class checks the uses of daemon method
    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(
                () -> {
                    try{
                        while(true){
                            TimeUnit.MILLISECONDS.sleep(800);
                            System.out.println(Thread.currentThread().getName());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        //setting daemon property...helps to stop the continous loop of the thread.
        t1.setDaemon(true);

        //starting thread t1
        t1.start();
        //setting time before printing exiting the main program
        TimeUnit.SECONDS.sleep(2);
        //printing exit message to the console
        System.out.println("Exiting the main program.");
    }
}
