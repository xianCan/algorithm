package algorithm.concurrent.c_007;

import java.util.concurrent.TimeUnit;

/**
 * @authod xianCan
 * @date 2018/12/26 14:09
 *
 * 对业务方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题
 */
public class Account {
    String name;
    double balance;

    public synchronized void set(String name, double balance){
        this.name=name;
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.balance=balance;
    }

    public /*synchronized*/ double getBalance(String name){//如果不对读方法加锁，就会读到旧数据，形成脏读
        return this.balance;
    }

    public static void main(String[] args){
        Account a = new Account();
        new Thread(()->a.set("zhangsan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));
    }
}
