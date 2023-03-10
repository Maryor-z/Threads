package com.maryor;

import static com.maryor.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_RED + "Hello from the main thread!");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run(){
                System.out.println(ANSI_PURPLE + "Hello from the anonymous class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Thread from anonymous class's implementation of run()");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnotherThread terminated, or timed out, so i am running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all, i was interrupted");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_GREEN + "hello again from main thread");
    }
}