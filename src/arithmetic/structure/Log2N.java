package arithmetic.structure;

/**
 * @author MaZhuli
 * @version 1.0.0
 * @package arithmetic.structure description
 * @since 2021/7/9
 */
public class Log2N {
    public static void main(String[] args) {
        int v = (int)(Math.log(7) / Math.log(2));
        System.out.println(v);
        System.out.println(1 << v-1);
    }
}
