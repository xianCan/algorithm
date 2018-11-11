package algorithm.stack;

import java.util.Iterator;

/**
 * 链表方式实现
 * @param <T>
 */
public class ListStack<T> implements MyStack<T> {

    private Node top = null;
    private int N=0;

    private class Node{
        T t;
        Node next;
    }
    @Override
    public MyStack<T> push(T t) {
        Node newTop = new Node();
        newTop.t = t;
        newTop.next = top;

        top = newTop;
        N++;
        return this;
    }

    @Override
    public T pop() throws Exception {
        if(isEmpty()){
            throw new Exception("stack is Empty");
        }
        T t = top.t;
        top = top.next;
        N--;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node cur = top;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                T t = cur.t;
                cur=cur.next;
                return t;
            }
        };
    }
}
