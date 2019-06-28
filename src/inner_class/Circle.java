package inner_class;

/**
 * @author MaZhuli
 * @description 成员内部类
 * @date 2019/6/28
 */
public class Circle {
    private double radius = 0;
    public static int count = 1;

    public Circle(double radius) {
        this.radius = radius;
    }
    //成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
    public class Draw {
        private double radius = 1;  //访问外部类的同名属性:外部类.this.属性名
        public void drawSahpe() {
            System.out.println(Circle.this.radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
        }
    }
    //虽然成员内部类可以无条件地访问外部类的成员，而外部类想访问成员内部类的成员却不是这么随心所欲了。
    // 在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问：

    public static void main(String[] args) {
        Draw draw = (new Circle(2)).new Draw();
        draw.drawSahpe();
    }
}
