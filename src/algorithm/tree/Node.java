package algorithm.tree;

/**
 * 叶子节点
 */
public class Node implements Comparable<Node> {

    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }
    public Node(int value,Node left,Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return o.value-this.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
