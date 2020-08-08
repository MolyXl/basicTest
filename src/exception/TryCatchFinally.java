package exception;

public class TryCatchFinally {
    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
    }

    public static int test() {
        //finally返回值为最终返回值,finally中修改不影响try返回值
        int i = 1;
        try {
            System.out.println(1 / 0);
            return ++i;
        } catch (Exception e) {
            return 1;
        } finally {
            ++i;
        }
    }
}
