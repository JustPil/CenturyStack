package stacktests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import stacks.LinkedListStack;

public class LinkedListStackTests {
    private final LinkedListStack<Integer> stack = new LinkedListStack<>();

    @Test
    public void addOneElement() {
        stack.push(1);
        var result = stack.peek();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void removeOneElement() {
        stack.push(1);
        stack.pop();
        var result = stack.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void popOnEmptyStack() {
        Assertions.assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    public void clearStack() {
        stack.push(1);
        stack.clear();
        var result = stack.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void add100Elements() {
        for(int i = 0; i < 100; i++) {
            stack.push(i);
        }
        var result = stack.getNumElements();
        Assertions.assertEquals(100, result);
    }

    @Test
    public void removeLargeNumberOfElements() {
        for(int i = 0, j = 0; i < 100; i++) {
            stack.push(i);
            if(j < 50) {
                stack.pop();
                j++;
            }
        }
        var result = stack.getNumElements();
        Assertions.assertEquals(50, result);
    }

    @Test
    public void getElementsAsString() {
        for(int i = 0; i < 3; i++) {
            stack.push(i + 1);
        }
        var result = stack.toString();
        Assertions.assertEquals("[1 2 3]", result);
    }

    @Test
    public void swapElements() {
        stack.push(1);
        stack.push(2);
        stack.swapStart();
        var result = stack.peek();
        Assertions.assertEquals(1, result);
    }
}
