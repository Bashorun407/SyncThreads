package Threads1;

import Threads1.Chat;

public class TalkSecond implements Runnable{

    Chat m;
    String [] s2 = {"I dey", "Family good", "Country no too tight...but we thank God", "We go gather for Benji brother wedding tomorrow."};

    //class constructor
    public TalkSecond(Chat m2){
        this.m = m2;
        //starts new thread
        new Thread(this, "Answer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < s2.length; i++){
            m.answer(s2[i]);
        }
    }
}
