package pattern.mediator;

/**
 * @author MaZhuli
 * @description
 * @date 2019/6/27
 */
public class User2 extends User {
    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}
