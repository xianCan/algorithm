package algorithm.concurrent.c_002;

/**
 * @authod xianCan
 * @date 2018/12/25 11:23
 *
 * synchronized关键字
 * 对某个对象加锁
 */
public class T {
    private int count = 10;

    public void m(){
        synchronized (this){ //任何线程要执行下面的代码，必须先拿到this的锁
            count--;
            System.out.println(Thread.currentThread().getName()+" count = "+count);
        }
    }
}
