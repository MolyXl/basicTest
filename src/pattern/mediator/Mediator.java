package pattern.mediator;

/**
 * @author MaZhuli
 * @description 中介者模式
 * @date 2019/6/27
 */
public interface Mediator {
    public void createMediator();

    public void workAll();

    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
