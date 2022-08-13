package multiThreading;

public class ThreadBasicsRunner {

    public static void main(String args[]) throws InterruptedException {
        Task1 task1 = new Task1();
          task1.start();

        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
         task2Thread.start();
         // we want to once task 1 and task 2 completed then main thread will execute
           task1.join();
           task2Thread.join();
        System.out.println("Bye main thread");

    }
}

class Task1 extends Thread
{
    public void run() {
        System.out.println("task 1 is kicked off");
        for(int i = 101 ; i<199; i++)
            System.out.println("i:=> "+ i);
        System.out.println("task 1 is completed now");
    }
}

class Task2 implements Runnable
{
    public void run() {
        System.out.println("task 2 is kicked off");
        for(int i = 201 ; i<299; i++)
            System.out.println("i:=> "+ i);
        System.out.println("task 2 is completed now");
    }
}
