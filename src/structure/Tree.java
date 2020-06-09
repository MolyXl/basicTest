package structure;

/**
 * @author mazhuli
 * @date 2020/6/9
 * @desc 这是一个树
 */
public class Tree {
    private Integer value;
    private Tree left;
    private Tree right;

    public Tree(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new Tree(value);
            } else {
                this.left.setValue(value);
            }
        } else {
            if (this.right == null) {
                this.right = new Tree(value);
            } else {
                this.right.setValue(value);
            }
        }
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(5);
        tree.setValue(4);
        tree.setValue(3);
        tree.setValue(8);
        tree.setValue(6);
        System.out.println(32);
    }
}
