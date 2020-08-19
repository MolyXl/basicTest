package thread.implement;

public class ExtendThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        ExtendThread extendTherad1 = new ExtendThread();
        ExtendThread extendTherad2 = new ExtendThread();
        extendTherad1.run();
        extendTherad2.run();
        extendTherad1.start();
        extendTherad2.start();
        //run():仅仅是封装被线程执行的代码，直接调用是普通方法
        //start():首先启动了线程，然后再由jvm去调用该线程的run()方法。
    }
}
