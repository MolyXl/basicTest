package spring.event.application.Io;

import org.springframework.context.ApplicationEvent;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc ${description}
 */
public class UserRegistryEvent extends ApplicationEvent {
    private String userName;

    /*public UserRegistryEvent(Object source) {
        super(source);
    }*/
    public UserRegistryEvent(Object source,String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
