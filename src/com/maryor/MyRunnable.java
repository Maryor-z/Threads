package com.maryor;

import static com.maryor.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Thread from MyRunnable implementation of run()");
    }
}
