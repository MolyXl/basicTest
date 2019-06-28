package inner_class;

import interfaces.Subject;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author MaZhuli
 * @description 局部内部类
 * @date 2019/6/28
 */
public class People {

    static class Inner {        //静态内部类
        private static int age = 90;

        public Inner() {
        }
    }

    class Man { //成员内部类
        public People getWoman() {
            class Woman extends People {   //局部内部类
                int age = 0;
            }
            return new Woman();
        }
    }

    public static void main(String[] args) {
        int a = 1;
        Subject subject = new Subject() {   //匿名内部类
            //匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。
            // 匿名内部类在编译的时候由系统自动起名为Outter$1.class。
            @Override
            public void print() {
                System.out.println(a);
            }
        };
        subject.print();
        Inner inner = new Inner();
        System.out.println(inner.age);
        //静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法，
        // 这点很好理解，因为在没有外部类的对象的情况下，可以创建静态内部类的对象，如果允许访问外部类的非static成员就会产生矛盾，
        // 因为外部类的非static成员必须依附于具体的对象。

        //局部内部类和匿名内部类只能访问局部final变量
    }
}
