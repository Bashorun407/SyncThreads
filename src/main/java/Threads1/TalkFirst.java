package Threads1;

import Threads1.Chat;

public class TalkFirst implements Runnable{

    Chat m;
    String[] s1 = {"How far na?", "How family?","How the country?","Where we go jam this weekend?"};

    public TalkFirst(Chat m1){
        this.m = m1;
        new Thread(this, "Question").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < s1.length; i++){
            m.question(s1[i]);
        }
    }
}
