package spring.event.application.Io;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc 已接口方式实现事件监听,实现PriorityOrdered接口排序
 */
@Component
public class SendCouponOnOrderCreateListener implements ApplicationListener<UserRegistryEvent> , PriorityOrdered {
    @Override
    public void onApplicationEvent(UserRegistryEvent userRegistryEvent) {
        System.out.println("发送优惠券" + userRegistryEvent.getUserName());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
