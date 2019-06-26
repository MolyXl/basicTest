package pattern.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author MaZhuli
 * @description 树节点
 * @date 2019/6/26
 */
public class TreeNode {
    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<TreeNode>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    //添加孩子节点
    public void add(TreeNode node) {
        node.setParent(this);
        children.add(node);
    }

    //删除孩子节点
    public void remove(TreeNode node) {
        children.remove(node);
        node.setParent(null);
    }

    //取得孩子节点
    public Enumeration<TreeNode> getChildren() {
        return children.elements();
    }
}
