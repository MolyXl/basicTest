package proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author MaZhuli
 * @description cglib动态代理
 * @date 2019/6/20
 */
//代理类是目标类的子类
public class CglibProxy implements MethodInterceptor {

    public <T>T getCglibProxy(Class<T> c){
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(c);
        // 设置enhancer的回调对象
        enhancer.setCallback(this);
        // 创建代理对象
        return (T)enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return object;
    }

    public static void main(String[] args) {

        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        //Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        //enhancer.setSuperclass(Service.class);
        // 设置enhancer的回调对象
        //enhancer.setCallback(new CglibProxy());
        // 创建代理对象
        //Service proxy= (Service)enhancer.create();

        Service proxy = new CglibProxy().getCglibProxy(Service.class);
        // 通过代理对象调用目标方法
        proxy.print();
    }
}
