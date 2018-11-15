package algorithm.sortAlgorithm;

/**
 * Created by xianCan on 2018/11/15 9:23
 *
 * 快排
 */
public class QuickSort {
    /**
     * 快速排序
     * @param arrays 需要排序的数组
     * @param L 指向数组第一个元素
     * @param R 指向数组最后一个元素
     */
    public static void quickSort(int[] arrays, int L, int R){
        int i=L;
        int j=R;
        //选取中间点作为支点
        int pivot = arrays[(L+R)/2];
        //对左右两端进行扫描，只要两端还没交替，就一直扫描
        while(i<=j){
            //寻找直到比支点大的数
            while(pivot>arrays[i])
                i++;
            //寻找直到比支点小的数
            while(pivot<arrays[j])
                j--;
            //两数交换
            if(i<=j){
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
                i++;
                j--;
            }
        }
        //上面的while保证了第一次排序后支点的左边比支点小，右边比支点大
        //“左边”再做排序，直到左边剩下一个数（递归出口）
        if(L<j){
            quickSort(arrays,L,j);
        }
        //“右边”再做排序，直到右边剩下一个数（递归出口）
        if(i<R){
            quickSort(arrays,i,R);
        }
    }
}
