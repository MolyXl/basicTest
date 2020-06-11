package spring.event.application.io;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc 已接口方式实现事件监听,实现Ordered接口排序
 */
@Component
public class SendEmailOnOrderCreateListener implements ApplicationListener<UserRegistryEvent> , Ordered {
    @Override
    public void onApplicationEvent(UserRegistryEvent userRegistryEvent) {
        System.out.println("发送邮件" + userRegistryEvent.getUserName());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
