package Threads2;

public class SecondTalker implements Runnable{

    Chat m;
    String [] s2 = {"Hey G", "Project dey arrange.", " When dem pay for the remaining batch...we go complete am.",
            " We go dey alright....last last."};
    //class constructor
    public SecondTalker(Chat m2){
        this.m = m2;
        //creating a Thread Object which calls its start method on this class object
        new Thread(this, "Answer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < s2.length; i++){
            m.answer(s2[i]);
        }
    }
}
