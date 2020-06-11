package arithmetic.structure;


import java.util.HashMap;
import java.util.Objects;

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
        if (value == null) {
            return;
        }
        if (this.value == null) {
            this.value = value;
        } else {
            if (value.equals(this.value)) {
                this.value = value;
            } else if (value < this.value) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(value, tree.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static void main(String[] args) {
       /* Tree tree = new Tree(5);
        tree.setValue(4);
        tree.setValue(3);
        tree.setValue(8);
        tree.setValue(6);*/
        HashMap hashMap = new HashMap();
        HashTest hashTest1 = new HashTest(1,2);
        HashTest hashTest2 = new HashTest(2,2);
        HashTest hashTest3 = new HashTest(3,2);
        HashTest hashTest4 = new HashTest(4,2);
        HashTest hashTest5 = new HashTest(5,2);
        HashTest hashTest6 = new HashTest(6,2);
        HashTest hashTest7 = new HashTest(7,2);
        HashTest hashTest8 = new HashTest(8,2);
        HashTest hashTest9 = new HashTest(9,2);
        HashTest hashTest10 = new HashTest(10,2);
        HashTest hashTest11 = new HashTest(11,2);
        HashTest hashTest12 = new HashTest(12,2);
        hashMap.put(hashTest1,1);
        hashMap.put(hashTest2,1);
        hashMap.put(hashTest3,1);
        hashMap.put(hashTest4,1);
        hashMap.put(hashTest5,1);
        hashMap.put(hashTest6,1);
        hashMap.put(hashTest7,1);
        hashMap.put(hashTest8,1);
        hashMap.put(hashTest9,1);
        hashMap.put(hashTest10,1);
        hashMap.put(hashTest11,1);
        hashMap.put(hashTest12,1);
    }

}
