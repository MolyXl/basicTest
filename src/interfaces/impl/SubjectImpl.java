package interfaces.impl;

import interfaces.Subject;

/**
 * @author MaZhuli
 * @description 实现
 * @date 2019/6/19
 */
public class SubjectImpl implements Subject {
    @Override
    public void print() {
        System.out.println("原方法");
    }
}
