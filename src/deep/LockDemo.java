package deep;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author MaZhuli
 * @version 1.0.0
 * @package deep description
 * @since 2021/7/1
 */
public class LockDemo {
    private static Object  o=new Object();
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
