package pattern.factory.common_factory;

import interfaces.Subject;
import interfaces.impl.SubjectImpl;
import interfaces.impl.SubjectImpl2;

/**
 * @author MaZhuli
 * @description 普通工厂
 * @date 2019/6/25
 */
public class ConmonFactory {
    public Subject getSubject(String name) {
        if (name != null && name.equals("1")) {
            return new SubjectImpl();
        } else if (name != null && name.equals("2")) {
            return new SubjectImpl2();
        } else {
            return null;
        }
    }
}
