package pattern.template;

/**
 * @author MaZhuli
 * @description 加法
 * @date 2019/6/26
 */
public class Plus extends AbstractCalculator {

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }

}
