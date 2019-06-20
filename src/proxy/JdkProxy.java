package proxy;

import interfaces.Subject;
import interfaces.impl.SubjectImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author MaZhuli
 * @description jdk动态代理
 * @date 2019/6/19
 */
public class JdkProxy implements InvocationHandler {

    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println("post");
        return result;
    }

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Subject jdkProxy = new JdkProxy(subject).getProxy();
        jdkProxy.print();
    }
}
