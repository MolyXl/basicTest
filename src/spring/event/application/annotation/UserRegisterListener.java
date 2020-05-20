package spring.event.application.annotation;

/**
 * @author mazhuli
 * @date 2020/5/20
 * @desc 注解方式实现监听
 */

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterListener {
    @EventListener
    @Order(1)
    public void sendMail(UserRegistryEvent event) {
        System.out.println(String.format("给用户【%s】发送注册成功邮件!", event.getUserName()));
        System.out.println(Thread.currentThread());
    }

    @Order(0)
    @EventListener
    public void sentCoupon(UserRegistryEvent event) {
        System.out.println("youhuiquan" + event.getUserName());
        System.out.println(Thread.currentThread());
    }
}

