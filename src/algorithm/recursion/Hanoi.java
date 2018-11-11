package algorithm.recursion;

/**
 * 汉诺塔问题
 */
public class Hanoi {
    /**
     *
     * @param n 共有n个盘子
     * @param A 开始的柱子
     * @param B 中间的柱子
     * @param C 目标柱子
     */
    public static void hanoiQuestion(int n, char A, char B, char C){
        //只有一个盘子的情况
        if(n==1){
            System.out.println("第一个盘子从"+A+"移到"+C);
        }else{
            //移动上面所有的盘子到中间位置
            hanoiQuestion(n-1, A, C, B);
            //移动下面的盘子
            System.out.println("第"+n+"个盘子从"+A+"移到"+C);
            //把上面的所有的盘子从中间位置移到目标位置
            hanoiQuestion(n-1, B, A, C);
        }
    }
}
