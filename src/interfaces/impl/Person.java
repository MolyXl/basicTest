package interfaces.impl;

import interfaces.Animal;

/**
 * @author MaZhuli
 * @description 人
 * @date 2019/6/26
 */
public class Person implements Animal {
    @Override
    public void run() {
        System.out.println("run with two legs");
    }
}
