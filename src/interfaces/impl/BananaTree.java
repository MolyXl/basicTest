package interfaces.impl;

import interfaces.Plant;

/**
 * @author MaZhuli
 * @description 苹果树
 * @date 2019/6/26
 */
public class BananaTree implements Plant {
    @Override
    public void grow() {
        System.out.println("banana");
    }
}
