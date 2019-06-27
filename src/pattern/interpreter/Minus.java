package pattern.interpreter;

/**
 * @author MaZhuli
 * @description
 * @date 2019/6/27
 */
public class Minus implements Expression {
    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}
