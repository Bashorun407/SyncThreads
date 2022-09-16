package Threads2;

public class FirstTalker implements Runnable{

    Chat m;
    String [] s1 = {"How far guy?", "How the project?", " When you go fit complete am?", "Everything go set."};
    //class constructor
    public FirstTalker(Chat m1){
        this.m = m1;
        //creating a Thread Object which calls its start method on this class object
        new Thread(this, "Question").start();
    }

    //implementing run() method of Runnable interface

    @Override
    public void run() {
        for (int i = 0; i < s1.length; i++){
            m.question(s1[i]);
        }
    }
}
