package algorithm.queue;

import java.util.Iterator;

public class ListQueue<T> implements MyQueue<T> {
    private Node first;
    private Node last;
    int N=0;

    private class Node{
        T t;
        Node next;
    }
    @Override
    public int szie() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public MyQueue<T> add(T t) {
        Node newNode = new Node();
        newNode.t = t;
        newNode.next = null;

        if(isEmpty()){
            last = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        N++;
        return this;
    }

    @Override
    public T remove() throws Exception {
        if(isEmpty()){
            throw new Exception("queue is empty");
        }
        T t = first.t;
        first = first.next;
        N--;

        if(isEmpty()){
            last =null;
        }
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node cur = first;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                T t =cur.t;
                cur = cur.next;
                return t;
            }
        };
    }
}
