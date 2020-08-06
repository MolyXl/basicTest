package exception;

public class TryCatchFinally {
    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
    }
    public static int test(){
        int i = 1;
        try {
            System.out.println(1/0);
            return ++i;
        }catch (Exception e){
            return 1;
        }finally {
            ++i;
        }
    }
}
