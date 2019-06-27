package pattern.strategy;

/**
 * @author MaZhuli
 * @description 减法
 * @date 2019/6/26
 */
public class Minus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] split = split(exp, "-");
        return split[0] - split[1];
    }
}
