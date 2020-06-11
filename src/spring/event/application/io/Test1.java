package spring.event.application.io;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mazhuli
 * @date 2020/5/20
 * @desc 面向接口方式
 */
public class Test1 {
    @Test
    public void test() {
        /*//创建事件广播器
        ApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
        //注册事件监听器
        applicationEventMulticaster.addApplicationListener(new SendEmailOnOrderCreateListener());
        //广播事件订单创建事件
        applicationEventMulticaster.multicastEvent(new UserRegistryEvent(applicationEventMulticaster,"haha"));*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);//扫描Component
        context.refresh();
        //获取用户注册服务
        UserRegisterService userRegisterService = context.getBean(UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("路人甲Java");
    }
}
