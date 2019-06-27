package pattern.iterator;

/**
 * @author MaZhuli
 * @description 迭代器
 * @date 2019/6/27
 */
public interface Iterator {
    public Object previous();

    public Object next();

    public boolean hasNext();

    public Object first();
}
