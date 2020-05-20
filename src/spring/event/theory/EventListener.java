package spring.event.theory;

/**
 * @author mazhuli
 * @date 2020/5/19
 * @desc 事件监听器
 */
public interface EventListener<T extends AbstractEvent> {
    /**
     * @param event 要响应的事件对象
     * @desc 此方法负责处理事件
     */
    void onEvent(T event);
}
