package pattern.builder;

import interfaces.Subject;
import interfaces.impl.SubjectImpl;
import interfaces.impl.SubjectImpl2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaZhuli
 * @description 建造者模式
 * @date 2019/6/26
 */
//工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象
public class Builder {
    private List<Subject> list = new ArrayList<Subject>();

    public List<Subject> getList() {
        return list;
    }

    public void setList(List<Subject> list) {
        this.list = list;
    }

    public void produceSubject1(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SubjectImpl());
        }
    }

    public void produceSubject2(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SubjectImpl2());
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceSubject1(2);
        builder.produceSubject2(3);
        int size = builder.getList().size();
        System.out.println(size);
    }
}
