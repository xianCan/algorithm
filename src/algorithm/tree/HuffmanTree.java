package algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xianCan
 * @date 2018/11/15 23:39
 *
 * 创建哈夫曼树
 */
public class HuffmanTree {

    public static Node createHumanTree(int[] arr){
        if(arr.length == 0 || arr == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        //把数组中的值依次放进ArrayList中
        for (int i:arr) {
            list.add(new Node(i));
        }
        //当列表中只剩一个数时，证明树已经创建完毕
        while (list.size()>1){
            //先排序，排倒序，减少删除操作时对数组的移动
            Collections.sort(list);
            //取数组中最小的两个数作为叶子节点
            Node left = list.get(list.size()-1);
            Node right = list.get(list.size()-2);
            //创建一个新的节点
            Node parent = new Node(left.value+right.value, left, right);
            //把取出来的两个节点删除
            list.remove(left);
            list.remove(right);
            //把新建的节点放入二叉树中
            list.add(parent);
        }
        return list.get(0);
    }

    public static void main(String[] args){
        int[] arr = {3,7,8,29,5,11,23,14};
        Node node = createHumanTree(arr);
        System.out.println(node);
    }

}
