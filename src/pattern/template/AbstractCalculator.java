package pattern.template;

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

    public final int calculate(String exp, String opt) {
        int array[] = split(exp, opt);
        return calculate(array[0], array[1]);
    }

    abstract public int calculate(int num1, int num2);

    public static void main(String[] args) {
        String exp = "8-8";
        AbstractCalculator cal = new Minus();
        int result = cal.calculate(exp, "-");
        System.out.println(result);
    }
}
