package pattern.state;

/**
 * @author MaZhuli
 * @description 状态模式
 * @date 2019/6/27
 */
//核心思想就是：当对象的状态改变时，同时改变其行为
public class State {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1() {
        System.out.println("execute the first opt!");
    }

    public void method2() {
        System.out.println("execute the second opt!");
    }
}
