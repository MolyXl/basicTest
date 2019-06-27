package pattern.memento;

/**
 * @author MaZhuli
 * @description 备份
 * @date 2019/6/27
 */
//备忘录模式:主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象
public class Memento {
    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
