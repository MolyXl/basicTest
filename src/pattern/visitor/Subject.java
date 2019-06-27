package pattern.visitor;

/**
 * @author MaZhuli
 * @description
 * @date 2019/6/27
 */
public interface Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}
