import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] stack;
    private int top;

    public MyStack() {
        stack = (T[]) new Object[10];
        top = -1;
    }

    public void push(T value) {
        if (top == stack.length - 1) {
            T[] newStack = (T[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        top++;
        stack[top] = value;
    }

    public void remove(int index) {
        if (index < 0 || index > top) {
            throw new IndexOutOfBoundsException("Неправильний індекс: " + index);
        }
        System.arraycopy(stack, index + 1, stack, index, top - index);
        stack[top] = null;
        top--;
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            stack[i] = null;
        }
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public T peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public T pop() {
        T value = peek();
        stack[top] = null;
        top--;
        return value;
    }
}