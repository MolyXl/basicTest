package pattern.template;

/**
 * @author MaZhuli
 * @description 乘法
 * @date 2019/6/26
 */
public class Multiply extends AbstractCalculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}
