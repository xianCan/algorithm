package algorithm.sortAlgorithm;

/**
 * 冒泡排序（外加小优化）
 */
public class BubbleSort {
    public void sortOfBubble(int[] arr){
        int temp;
        //记录是否发生了交换
        int isChange;
        //外循环排序的次数
        for(int i=0;i<arr.length;i++){
            //每一次外循环就重新赋值
            isChange = 0;
            //内循环是当前外循环需要比较的次数
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //进到if条件里面，证明发生了置换
                    isChange = 1;
                }
            }
            //如果比较完一次外循环没有发生交换，则已经排好序了
            if(isChange == 0){
                break;
            }
        }
    }
}
