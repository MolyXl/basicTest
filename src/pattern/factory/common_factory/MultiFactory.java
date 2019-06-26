package pattern.factory.common_factory;

import interfaces.Subject;
import interfaces.impl.SubjectImpl;
import interfaces.impl.SubjectImpl2;

/**
 * @author MaZhuli
 * @description 普通工厂
 * @date 2019/6/25
 */
public class MultiFactory {
    public Subject getSubjectImpl() {
        return new SubjectImpl();
    }

    public Subject getSubjectImpl2() {
        return new SubjectImpl2();
    }
}
