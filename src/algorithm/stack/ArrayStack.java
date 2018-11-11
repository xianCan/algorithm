package algorithm.stack;

import java.util.Iterator;

/**
 * 数组方式实现
 * @param <T>
 */
public class ArrayStack<T> implements MyStack<T> {

    //栈元素数组，只能通过转型来创建泛型数组
    private T[] a = (T[]) new Object[1];

    //元素数量
    private int N=0;

    @Override
    public MyStack<T> push(T t) {
        check();
        a[N++] = t;
        return this;
    }

    @Override
    public T pop() throws Exception {
        if(isEmpty()){
            throw new Exception("stack is empty");
        }
        T t = a[--N];

        check();
        //避免对象游离
        a[N] = null;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        //返回逆序遍历的迭代器
        return new Iterator<T>() {
            private int i =N;
            @Override
            public boolean hasNext() {
                return i>0;
            }

            @Override
            public T next() {
                return a[--i];
            }
        };
    }

    private void check(){
        if(N >= a.length){
            resize(2*a.length);
        }else if(N>0 && N<=a.length/4){
            resize(a.length/2);
        }
    }

    /**
     * 调整数组大小，使得栈具有伸缩性
     */
    private void resize(int size){
        T[] b = (T[]) new Object[size];
        for (int i =0; i<N; i++){
            b[i] = a[i];
        }
        a=b;
    }
}
