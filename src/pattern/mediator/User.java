package pattern.mediator;

/**
 * @author MaZhuli
 * @description 用户
 * @date 2019/6/27
 */
public abstract class User {
    private Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void work();
}
