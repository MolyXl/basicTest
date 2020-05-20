package spring.event.theory;

import org.springframework.stereotype.Component;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc ${description}
 */
@Component
public class SendEmailOnUserRegisterSuccessListener implements EventListener<UserRegisterSuccessEvent> {
    @Override
    public void onEvent(UserRegisterSuccessEvent event) {
        System.out.println(String.format("给用户【%s】发送注册成功邮件!", event.getUserName()));
    }
}
