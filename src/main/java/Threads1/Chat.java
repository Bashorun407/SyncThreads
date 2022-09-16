package Threads1;

public class Chat {
    Boolean flag = false;

    //synchronized method for Questions
    public  synchronized  void  question (String message){

        if (flag){
            try{
                wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(message);
        flag = true;
        notify();
    }

    public synchronized void answer (String message){

        if (!flag){
            try{
                wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message);
        flag = false;
        notify();
    }
}
