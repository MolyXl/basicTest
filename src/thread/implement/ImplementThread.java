package thread.implement;

public class ImplementThread implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        for (int i = 0; i < 100; i++) {
            if (i == 10) {
                Thread.yield();//yield方法会先让别的线程执行，但是不确保真正让出
            }
            if (i == 50) {
                try {
                    Thread.sleep(100);//进入计时等待状态，等时间到了，进入的是就绪状态而并非是运行状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ImplementThread implementThread = new ImplementThread();
        Thread thread1 = new Thread(implementThread);
        Thread thread2 = new Thread(implementThread);
        thread1.setDaemon(false);//设置守护线程
        thread1.start();
        //thread1.join();//等待该线程执行完毕后才执行别的线程
        //thread1.wait(3000);//计时等待(如果带时间参数)
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}
