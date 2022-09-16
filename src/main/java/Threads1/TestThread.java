package Threads1;

import Threads1.Chat;
import Threads1.TalkFirst;
import Threads1.TalkSecond;

public class TestThread {

    //this class demonstrates how threads communicates with each other
    public static void main(String[] args) {
        Chat m  = new Chat();
        new TalkFirst(m);
        new TalkSecond(m);
    }
}
