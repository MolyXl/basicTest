package pattern.observer;

/**
 * @author MaZhuli
 * @description 观察者1
 * @date 2019/6/27
 */
public class Observer1 implements Observer{
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
