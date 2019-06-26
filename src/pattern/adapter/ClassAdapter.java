package pattern.adapter;

import pattern.adapter.source.Source;
import pattern.adapter.source.TargetInterface;

/**
 * @author MaZhuli
 * @description 类适配器
 * @date 2019/6/26
 */
public class ClassAdapter extends Source implements TargetInterface {
    @Override
    public void love() {
        System.out.println("I love blingbiang");
    }

    public static void main(String[] args) {
        TargetInterface targetInterface = new ClassAdapter();
        targetInterface.like();
        targetInterface.love();
    }
}
