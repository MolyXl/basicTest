package pattern.proxy;

import interfaces.Subject;
import interfaces.impl.SubjectImpl;
import interfaces.impl.SubjectImpl2;

/**
 * @author MaZhuli
 * @description 代理模式
 * @date 2019/6/26
 */
public class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void print() {
        System.out.println("before");
        subject.print();
        System.out.println("after");
    }

    public static void main(String[] args) {
        Subject subject = new Proxy(new SubjectImpl2());
        subject.print();
    }
}
