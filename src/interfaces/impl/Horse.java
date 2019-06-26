package interfaces.impl;

import interfaces.Animal;

/**
 * @author MaZhuli
 * @description 马
 * @date 2019/6/26
 */
public class Horse implements Animal {
    @Override
    public void run() {
        System.out.println("run with four legs");
    }
}
