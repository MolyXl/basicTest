package pattern.memento;

/**
 * @author MaZhuli
 * @description 存储
 * @date 2019/6/27
 */
public class Storage {
    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
