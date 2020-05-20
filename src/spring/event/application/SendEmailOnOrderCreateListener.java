package spring.event.application;

import org.springframework.context.ApplicationListener;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc ${description}
 */
public class SendEmailOnOrderCreateListener implements ApplicationListener<UserRegistryEvent> {
    @Override
    public void onApplicationEvent(UserRegistryEvent userRegistryEvent) {
        System.out.println("发送邮件" + userRegistryEvent.getUserName());
    }
}
