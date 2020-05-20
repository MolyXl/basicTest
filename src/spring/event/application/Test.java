package spring.event.application;

import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * @author mazhuli
 * @date 2020/5/20
 * @desc ${description}
 */
public class Test {
    @org.junit.Test
    public void test() {
        //创建事件广播器
        ApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
        //注册事件监听器
        applicationEventMulticaster.addApplicationListener(new SendEmailOnOrderCreateListener());
        //广播事件订单创建事件
        applicationEventMulticaster.multicastEvent(new UserRegistryEvent(applicationEventMulticaster,"haha"));
    }
}
