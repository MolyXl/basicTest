package spring.event.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc 用户注册服务
 */
public class UserRegisterService {
    //事件发布者
    private EventMulticaster eventMulticaster;

    /**
     * @desc 注册用户
     * @param userName 用户名
     */
    public void registerUser(String userName) {
        //用户注册(将用户信息入库等操作)
        System.out.println(String.format("用户【%s】注册成功", userName));
        //广播事件
        this.eventMulticaster.multicastEvent(new UserRegisterSuccessEvent(this, userName));
    }

    public EventMulticaster getEventMulticaster() {
        return eventMulticaster;
    }

    public void setEventMulticaster(EventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }

    public static void main(String[] args) {
        List list =new ArrayList();
        list.add(1);
        List a = new ArrayList();
        a.addAll(list);
        //a= list;
        a.add(2);
        System.out.println(a.size());
        System.out.println(list.size());

    }
}

