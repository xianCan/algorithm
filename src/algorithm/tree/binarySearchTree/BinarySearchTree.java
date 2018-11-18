package algorithm.tree.binarySearchTree;

/**
 * @author xianCan
 * @date 2018/11/18 19:28
 *
 * 二叉查找树
 */
public class BinarySearchTree {

    Node root;

    /**
     * 向二叉查找树中添加节点
     * @param node
     */
    public void add(Node node){
        //如果是一棵空树
        if(root==null)root=node;
        else addNode(root,node);
    }

    /**
     * 对内方法：向子树中添加节点
     * @param root 根节点
     * @param node 想添加的节点
     */
    private void addNode(Node root,Node node){
        if(node==null){
            return;
        }
        //判断传入的节点的值比当前子树的根节点的值大还是小
        //添加的节点比当前节点的值小
        if(node.value<root.value){
            //如果左节点为空
            if(root.left==null) root.left=node;
            //如果不为空
            else addNode(root.left,node);
        }else{
            if(root.right==null) root.right=node;
            else addNode(root.right,node);
        }
    }

    /**
     * 中序遍历对外方法
     */
    public void midShow(){
        midShow(root);
    }

    /**
     * 对内方法：中序遍历二叉树
     * @param root 根节点
     */
    private void midShow(Node root){
        if(root==null){
            return;
        }
        midShow(root.left);
        System.out.println(root.value);
        midShow(root.right);
    }

    /**
     * 查找某一个值
     * @param value 要查找的值
     * @return
     */
    public Node search(int value){
        return searchValue(root,value);
    }

    /**
     * 对内方法：查找某一个值得迭代方法
     * @param root 根节点
     * @param value 要查找的值
     * @return
     */
    private Node searchValue(Node root,int value){
        if(root==null) return null;
        //如果相等，返回根节点
        if(value==root.value) return root;
        //如果小于根节点的值，往左边找
        else if(value<root.value){
            return searchValue(root.left,value);
        }
        //如果大于根节点的值，往右边找
        else {
            return searchValue(root.right, value);
        }
    }

    /**
     * 删除节点
     * @param value 要删除的值
     */
    public Node delete(int value){
        if(root==null) return null;
        else{
            //找到这个节点
            Node target = search(value);
            //如果没有这个节点
            if(target==null) return null;
            // 如果有，找到它的父节点
            Node parent = searchParent(value);
            //如果要删除的是叶子节点
            if(target.left==null && target.right==null) {
                //判断删除的是左节点还是右节点
                if (parent.left.value == value) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            //要删除的节点有两个子节点的情况
            else if(target.left!=null && target.right!=null){ /**
                                                                * 这个地方返回值有问题
                                                                */
                //删除右子树中值最小的节点，获取该节点的值
                int min = deleteMin(target.right);
                //替换目标节点中的值
                target.value=min;
            }
            //要删除的节点只有一个左子节点，让左子节点直接指向父节点
            else if(target.left!=null&&target.right==null){
                if (parent.left.value == value) {
                    parent.left = target.left;
                } else {
                    parent.right = target.left;
                }
            }
            //要删除的节点只有一个左子节点，让左子节点直接指向父节点
            else{
                if (parent.left.value == value) {
                    parent.left = target.right;
                } else {
                    parent.right = target.right;
                }
            }
            return target;
        }
    }

    /**
     * 删除右子树中值最小的节点，获取该节点的值
     * @param node 右节点
     * @return
     */
    private int deleteMin(Node node) {
        Node target = node;
        //循环找到右子树中的最左节点
        while(target.left!=null){
            target=target.left;
        }
        //如果这个节点有子节点，有也是有右子节点,调用删除方法
        delete(target.value);
        return target.value;
    }

    /**
     * 对外方法：搜索父节点
     * @param value 要寻找的值
     * @return
     */
    public Node searchParent(int value){
        return searchParent(root,value);
    }

    /**
     * 对内方法：搜索父节点
     * @param root 根节点
     * @param value 要找的值
     * @return
     */
    public Node searchParent(Node root,int value){
        if(root==null) return null;
        //如果左子节点不为空并且左子节点的值等于想要查的值，当前节点就是父节点；右子节点同理
        if(( root.left != null && root.left.value == value ) || ( root.right != null && root.right.value == value ))
            return root;
        else{
            //小于根节点，从左边找
            if(value<root.value)
                return searchParent(root.left,value);
            //从右边找
            else
                return searchParent(root.right,value);
        }
    }

    //测试
    public static void main(String[] args){
        int[] arr = new int[]{7,3,10,12,5,1,9};
        BinarySearchTree bst = new BinarySearchTree();
        for(int i:arr){
            bst.add(new Node(i));
        }
        //bst.frontShow();
        //Node node = bst.search(10);
        Node node = bst.searchParent(3);
        System.out.println(node.value);
    }
}
