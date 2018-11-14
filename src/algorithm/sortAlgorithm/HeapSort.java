package algorithm.sortAlgorithm;

/**
 * 堆排序：
 *      堆排序是将数据考成是完全二叉树，根据完全二叉树的特性来进行排序的一种算法
 *      1.最大堆要求节点的元素都不小于其孩子，最小堆要求节点元素都不大与其左右孩子
 *      2.那么处于最大堆的根节点的元素一定是这个堆的最大值
 */
public class HeapSort {
    /**
     * 堆排序
     */
    public static void sortOfHeap(int[] arrays){
        for(int i=0;i<arrays.length;i++){
            //每次建堆就可以排除一个元素
            maxHeapify(arrays,arrays.length-1);
            //交换
            int temp = arrays[0];
            arrays[0] = arrays[arrays.length-1-i];
            arrays[arrays.length-1-i] = temp;
        }
    }
    /**
     * 完成一次建堆，最大值在堆的顶部（根节点）
     * @param arrays
     * @param size
     */
    public static void maxHeapify(int[] arrays, int size){
        //从数组的尾部开始，直到第一个元素（下标为0）
        for (int i=size-1;i>=0;i--){
            heapify(arrays, i, size);
        }
    }
    /**
     * 建堆
      * @param arrays   看作是完全二叉树
     * @param currentRootNode   当前父节点位置
     * @param size  节点总数
     */
    public static void heapify(int[] arrays, int currentRootNode, int size){
        if(currentRootNode < size) {
            //左子树和右子树的位置
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;
            //把当前父节点位置看成是最大的
            int max = currentRootNode;
            if (left < size) {
                //如果比当前根元素要大，记录它的位置
                if(arrays[max] < arrays[left]){
                    max= left;
                }
            }
            if(right < size){
                //如果比当前根元素要大，记录它的位置
                if(arrays[max] < arrays[left]){
                    max = right;
                }
            }
            //如果最大的不是根元素位置，那么就交换
            if(max != currentRootNode){
                int temp = arrays[max];
                arrays[max] = arrays[currentRootNode];
                arrays[currentRootNode] = temp;
            }

            //继续比较，直到完成一次建堆
            heapify(arrays,max,arrays.length);
        }
    }
}
