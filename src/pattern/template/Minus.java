package pattern.template;

/**
 * @author MaZhuli
 * @description 减法
 * @date 2019/6/26
 */
public class Minus extends AbstractCalculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
