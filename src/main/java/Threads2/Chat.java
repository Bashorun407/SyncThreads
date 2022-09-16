package Threads2;

public class Chat {

    Boolean flag = false;

    public synchronized void question (String msg){
        try{
            if (flag){
                wait();
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        flag = true;
        notify();
    }

    public synchronized void answer (String msg){
        try{
            if (!flag){
                wait();
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        flag = false;
        notify();
    }


}
