package pattern.observer;

/**
 * @author MaZhuli
 * @description 观察者2
 * @date 2019/6/27
 */
public class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}
