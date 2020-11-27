package thread.implement;

public class ExtendThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
        System.out.println("interrupted");
    }


    public static void main(String[] args) throws InterruptedException {
        ExtendThread extendThread1 = new ExtendThread();
        //extendThread1.start();
        //extendThread1.wait();
        Thread.sleep(5);
        extendThread1.interrupt();

        //run():仅仅是封装被线程执行的代码，直接调用是普通方法
        //start():首先启动了线程，然后再由jvm去调用该线程的run()方法。
        new Thread(() -> {
            System.out.println(23);
        }).start();
    }
}
