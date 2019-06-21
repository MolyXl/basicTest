package proxy;

/**
 * @author MaZhuli
 * @description 业务类
 * @date 2019/6/20
 */
public class Service {

    public void print() {
        System.out.println(234);
    }
    /**
     * @description: Cglib是无法代理final修饰的方法
     * @author: MaZhuli
     * @time: 2019/6/20 15:42
     * @param:
     * @return:
     */
    final public int getNo() {
        return 1;
    }

}
