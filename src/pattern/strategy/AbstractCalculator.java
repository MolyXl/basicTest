package pattern.strategy;

/**
 * @author MaZhuli
 * @description 抽象类, 提供辅助函数,非必须
 * @date 2019/6/26
 */
public abstract class AbstractCalculator {
    public int[] split(String exp, String opt) {
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}
