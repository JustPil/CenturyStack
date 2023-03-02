package stacks;

public interface CenturyStackInterface<T> {
    int SIZE = 100;
    boolean isEmpty();
    boolean isFull();
    void pop();
    void push(T t);
    T peek();
    void clear();
    String toString();
    void swapStart();
    int getNumElements();
}
