package stacks;

import exceptions.EmptyStackPop;

public class ArrayStack<T> implements CenturyStackInterface<T> {
    private T[] arr = (T[]) new Object[SIZE];
    private int numElements = 0;

    /**
     * isEmpty Tests if the first array element is null.
     * @return True if first element is null, false otherwise.
     */
    public boolean isEmpty() {
        return arr[0] == null;
    }

    /**
     * isFull tests if the last array element is not null.
     * @return True if last element is not null, false otherwise.
     */
    public boolean isFull() {
        return arr[99] != null;
    }

    /**
     * pop Sets the last non-null array's index value to null, effectively removing the last element's previously
     * inputted value. Throws an EmptyStackPop exception if attempted on an empty stack.
     */
    public void pop() {
        if(arr[0] == null) {
            throw new EmptyStackPop("Pop attempted on an empty stack.");
        } else {
            arr[--numElements] = null;
        }
    }

    /**
     * push Sets the first null index of the array to the value that is passed in. If the array is full, the last
     * index of the array is removed and replaced with the value passed in.
     * @param t The value to insert in the array.
     */
    public void push(T t) {
        if(numElements == 100) {
            pop();
            push(t);
        } else {
            arr[numElements++] = t;
        }
    }

    /**
     * peek Returns the value of the last non-null index in the array.
     * @return The value of the last non-null index in the array.
     */
    public T peek() {
        return isEmpty() ? null : arr[numElements - 1];
    }

    /**
     * clear Sets the values of the non-null array elements to null, effectively clearing the array. Resets the
     * topIndex variable to 0.
     */
    public void clear() {
        while(arr[0] != null) {
            arr[--numElements] = null;
        }
    }

    /**
     * toString Concatenates the array values to a String.
     * @return The array values concatenated as a String.
     */
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < numElements; i++) {
            str.append(arr[i]);
            str.append(i != numElements - 1 ? " " : "");
        }
        return str.toString().concat("]");
    }

    /**
     * swapStart Swaps the first and second elements that were added to the stack.
     */
    public void swapStart() {
        if(arr.length == 0 || arr[1] == null) {
            return;
        } else {
            T temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
    }

    /**
     * getNumElements Returns the number of elements contained in the Stack.
     * @return The number of elements contained in the Stack.
     */
    public int getNumElements() {
        return numElements;
    }
}
