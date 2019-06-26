package pattern.adapter;

import pattern.adapter.source.TargetInterface;

/**
 * @author MaZhuli
 * @description 接口适配器
 * @date 2019/6/26
 */
//当接口包含太多方法时,不希望实现其所有方法,可以新建抽象类,实现其所有方法,具体实现类选择实现
public abstract class InterfaceAdapter implements TargetInterface {
    @Override
    public abstract void like();

    @Override
    public abstract void love();
}
