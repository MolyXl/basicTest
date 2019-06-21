package circulation;

/**
 * @author MaZhuli
 * @description 退出循环
 * @date 2019/6/20
 */
public class BreakAndContinue {
    //break退出当前循环,配合标签可退出任意循环
    //continue跳过当前循环,配合标签可跳过任意循环
    public static void main(String[] args) {
        sign:
        for (int i = 0; i < 3; i++) {
            System.out.print(i);
            /*if (i == 1) {
                continue sign;
            }*/
            for (int k = 1; k < 4; k++) {
                if (k == 2) {
                    continue sign; //break退出当前循环,配合标签可退出任意循环
                }
                System.out.print(k);
            }
            System.out.println();
        }
    }
}
