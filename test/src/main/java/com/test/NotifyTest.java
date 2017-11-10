package com.test;

/**
 * User: wcy
 * Date: 2017/8/29
 * Time: 14:21
 */
public class NotifyTest {
    private String flag[] = { "true" };

    private static volatile int count = 0;

    class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (flag) {
                flag[0] = "false";
                flag.notifyAll();
                try {
                    sleep(3000);
                    System.out.println("最终结果"+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        public void run() {
//            synchronized (flag) {
//                while (flag[0] != "false") {
                    System.out.println(getName() + " begin waiting!");
                    long waitTime = System.currentTimeMillis();
//                    try {
//                        flag.wait();
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    for(int i=0;i<5;i++){
                        count++;
                    }
//                }
                System.out.println(getName() + " end waiting!"+count);
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Run!");
        NotifyTest test = new NotifyTest();
        NotifyThread notifyThread = test.new NotifyThread("notify01");
        WaitThread waitThread01 = test.new WaitThread("waiter01");
        WaitThread waitThread02 = test.new WaitThread("waiter02");
        WaitThread waitThread03 = test.new WaitThread("waiter03");
        notifyThread.start();
        waitThread01.start();
        waitThread02.start();
        waitThread03.start();
    }

}