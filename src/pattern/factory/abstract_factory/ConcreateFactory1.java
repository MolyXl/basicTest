package pattern.factory.abstract_factory;

import interfaces.Animal;
import interfaces.Plant;
import interfaces.impl.BananaTree;
import interfaces.impl.Horse;

/**
 * @author MaZhuli
 * @description 具体工厂
 * @date 2019/6/26
 */
public class ConcreateFactory1 extends AbstractFactory {
    @Override
    public Animal newAnimal() {
        return new Horse();
    }

    @Override
    public Plant newPlant() {
        return new BananaTree();
    }
}
