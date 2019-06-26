package pattern.prototype;

/**
 * @author MaZhuli
 * @description 原型模式
 * @date 2019/6/26
 */
//克隆方式,深浅复制
public class Prototype implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }
}
