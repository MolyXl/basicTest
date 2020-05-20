package spring.event.theory;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc 测试
 */
public class EventTest {
    @Test
    public void test0() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        //SendEmailOnUserRegisterSuccessListener bean = context.getBean(SendEmailOnUserRegisterSuccessListener.class);
        //获取用户注册服务
        UserRegisterService userRegisterService = context.getBean(UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("路人甲Java");
    }
}
