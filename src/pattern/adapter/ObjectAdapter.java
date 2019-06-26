package pattern.adapter;

import pattern.adapter.source.Source;
import pattern.adapter.source.TargetInterface;

/**
 * @author MaZhuli
 * @description 对象适配器
 * @date 2019/6/26
 */
public class ObjectAdapter implements TargetInterface {
    //持有对象
    private Source source;

    public ObjectAdapter(Source source) {
        this.source = source;
    }

    @Override
    public void like() {
        source.like();
    }

    @Override
    public void love() {
        System.out.println("I love blingbiang");
    }

    public static void main(String[] args) {
        TargetInterface targetInterface = new ObjectAdapter(new Source());
        targetInterface.like();
        targetInterface.love();
    }
}
