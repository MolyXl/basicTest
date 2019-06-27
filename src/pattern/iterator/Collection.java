package pattern.iterator;

/**
 * @author MaZhuli
 * @description 迭代子模式
 * @date 2019/6/27
 */
//迭代器模式就是顺序访问聚集中的对象,一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问
public interface Collection {
    public Iterator iterator();

    public Object get(int i);

    public int size();

    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
