package pattern.singleton;

/**
 * @author MaZhuli
 * @description 单例模式
 * @date 2019/6/26
 */
public class Singleton {
    //1,持有私有静态实例
    private static Singleton instance = null;  //未直接初始化,可以做到懒加载

    //2,私有化构造方法,防止创建实例
    private Singleton() {
    }

    //3,获取实例的静态方法
    /*public static  *//*synchronized 此处每次获取实例都会进入锁判断,效率低*//* Singleton getInstance() {
        if (instance == null) {             //多线程情况下,同时进入,会创造多个实例
            synchronized (instance) {       //锁加在此处,只有第一次的时候才会进入锁判断
                if (instance == null) {
                    instance = new Singleton(); //在Java指令中创建对象和赋值操作是分开进行的，
                    // 也就是说instance = new Singleton();语句是分两步执行的。
                    // 但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，
                    // 然后直接赋值给instance成员，然后再去初始化这个Singleton实例。
                }
            }
             // syncInit(); //把实例的创建放到同步方法中,同样可以解决未初始化完的情况
        }
        return instance;
    }*/
    //
    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton();
        }
    }

    //内部类的方法,类的加载是线程互斥的,静态成员变量在类加载时初始化,不会出现未初始化完的情况
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    //3,获取实例的静态方法
    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }

}
