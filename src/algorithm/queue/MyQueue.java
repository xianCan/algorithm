package algorithm.queue;

public interface MyQueue<T> extends Iterable<T> {
    int szie();
    boolean isEmpty();
    MyQueue<T> add(T t);
    T remove() throws Exception;
}
