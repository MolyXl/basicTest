package spring.event.application.Io;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author mazhuli
 * @date 2020/5/20
 * @desc ${description}
 */
@Component
public class UserRegisterService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 负责用户注册及发布事件的功能
     */
    public void registerUser(String userName) {
        //用户注册(将用户信息入库等操作)
        System.out.println(String.format("用户【%s】注册成功", userName));
        //发布注册成功事件
        this.applicationEventPublisher.publishEvent(new UserRegistryEvent(this, userName));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
