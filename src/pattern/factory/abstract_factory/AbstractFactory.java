package pattern.factory.abstract_factory;

import interfaces.Animal;
import interfaces.Plant;

/**
 * @author MaZhuli
 * @description 抽象工厂
 * @date 2019/6/26
 */
//抽象工厂模式的扩展有一定的“开闭原则”倾斜性：
//当增加一个新的产品族时只需增加一个新的具体工厂，不需要修改原代码，满足开闭原则。
//当产品族中需要增加一个新种类的产品时，则所有的工厂类都需要进行修改，不满足开闭原则。
public abstract class AbstractFactory {
    public abstract Animal newAnimal();

    public abstract Plant newPlant();
}
