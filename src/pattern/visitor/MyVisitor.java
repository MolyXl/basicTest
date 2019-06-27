package pattern.visitor;

/**
 * @author MaZhuli
 * @description 访问者实现
 * @date 2019/6/27
 */
public class MyVisitor implements Visitor {
    @Override
    public void visit(Subject sub) {
        System.out.println("visit the subject："+sub.getSubject());
    }
}
