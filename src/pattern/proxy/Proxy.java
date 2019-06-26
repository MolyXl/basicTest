package pattern.proxy;

import interfaces.Subject;
import interfaces.impl.SubjectImpl;
import interfaces.impl.SubjectImpl2;

/**
 * @author MaZhuli
 * @description 代理模式/桥接模式
 * @date 2019/6/26
 */
public class Proxy implements Subject {
    private Subject subject;    //桥接模式这儿放的是接口
    private SubjectImpl subjectImpl;    //代理模式这儿放的是具体实现类

    public Proxy(Subject subject) {
        this.subject = subject;
    }
    public Proxy(SubjectImpl subjectImpl) {
        this.subjectImpl = subjectImpl;
    }

    @Override
    public void print() {
        //System.out.println("before");
        subject.print();
        //System.out.println("after");
    }

    public static void main(String[] args) {
        Subject subject = new Proxy(new SubjectImpl());//如果print方法未修改,这踏马就是个桥接模式
        subject.print();
    }
}
