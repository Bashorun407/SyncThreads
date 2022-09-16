package Threads2;

public class TestThread {

    //this class demonstrates how two synchronized threads communicate with each other
    public static void main(String[] args) {

        Chat chat = new Chat();

        //creating objects of the two Talkers
        new FirstTalker(chat);
        new SecondTalker(chat);
    }
}
