package spring.event.theory;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc 事件对象
 */
public class AbstractEvent {
    //事件源
    protected Object source;

    public AbstractEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

}
