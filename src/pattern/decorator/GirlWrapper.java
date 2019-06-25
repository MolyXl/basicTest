package pattern.decorator;

/**
 * @author MaZhuli
 * @description 装饰类,对修改关闭,对扩展开放,装饰可以套叠
 * @date 2019/6/25
 */
public abstract class GirlWrapper extends Girl {
    public abstract String getDescription();
}
