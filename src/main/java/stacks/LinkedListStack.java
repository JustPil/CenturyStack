package stacks;

import exceptions.EmptyStackPop;
import nodes.Node;

public class LinkedListStack<T> implements CenturyStackInterface<T> {
    private Node<T> stackTop;
    private int numElements = 0;

    /**
     * Constructor sets the first node of the stack to null.
     */
    public LinkedListStack() {
        stackTop = null;
    }

    /**
     * isEmpty Tests if the stack is empty.
     * @return True if the stack's top node is null, false otherwise.
     */
    public boolean isEmpty() {
        return (stackTop == null);
    }

    /**
     * isFull Outputs that the stack is not full.
     * @return False because a stack implemented with a linked list cannot be full.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * pop Throws EmptyStackPop if the stack is empty, otherwise dereferences the most recently pushed node.
     */
    public void pop() {
        if(isEmpty())
        {
            throw new EmptyStackPop("Pop attempted on an empty stack.");
        } else {
            stackTop = stackTop.getNext();
        }
        numElements--;
    }

    /**
     * push Creates a new node for the stack.
     * @param t The new node to push.
     */
    public void push(T t) {
        Node<T> node = new Node<>(t);
        node.setNext(stackTop);
        stackTop = node;
        numElements++;
    }

    /**
     * peek Throws EmptyStackPop if the stack is empty, otherwise returns the data of the most recently pushed node.
     * @return The data held by the top node.
     */
    public T peek() {
        if(isEmpty()) {
            return null;
        } else {
            return stackTop.getData();
        }
    }

    /**
     * clear Dereferences the pushed nodes.
     */
    public void clear() {
        stackTop = null;
        numElements = 0;
    }

    /**
     * toString Returns the data held by each node in the stack as a String.
     * @return The data held by each node in the stack.
     */
    public String toString() {
        StringBuilder str = new StringBuilder("]");
        Node<T> parser = stackTop;
        while(parser != null) {
            str.append(parser.getData());
            str.append(parser.getNext() != null ? " " : "[");
            parser = parser.getNext();
        }
        str.reverse();
        return str.toString();
    }

    /**
     * swapStart Swaps the first and second elements in the stack iteratively.
     */
    public void swapStart() {
        if(stackTop == null || numElements < 2) {
            return;
        } else if(numElements == 2) {
            Node<T> parser = stackTop;
            Node<T> swap = parser.getNext();
            swap.setNext(parser);
            parser.setNext(null);
            stackTop = swap;
        } else {
            Node<T> parser = stackTop;
            while(parser.getNext() != null) {
                if(parser.getNext().getNext().getNext() == null) {
                    Node<T> swap1 = parser.getNext();
                    Node<T> swap2 = parser.getNext().getNext();
                    swap2.setNext(swap1);
                    swap1.setNext(null);
                    parser.setNext(swap2);
                    return;
                }
                parser = parser.getNext();
            }
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
