package pattern.visitor;

/**
 * @author MaZhuli
 * @description
 * @date 2019/6/27
 */
public class MySubject implements Subject {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}
