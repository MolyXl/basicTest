package pattern.interpreter;

/**
 * @author MaZhuli
 * @description
 * @date 2019/6/27
 */
//解释者模式
public interface Expression {
    public int interpret(Context context);

    public static void main(String[] args) {
        int result = new Minus().interpret((new Context(new Plus().interpret(new Context(9, 2)), 8)));
        System.out.println(result);
    }
}
