import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        // Конструктор без параметрів
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value, tail, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node<T> currentNode = getNode(index);
        Node<T> prevNode = currentNode.prev;
        Node<T> nextNode = currentNode.next;
        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode;
            currentNode.prev = null;
        }
        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
            currentNode.next = null;
        }
        currentNode.value = null;
        size--;
    }

    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.next;
            currentNode.prev = null;
            currentNode.next = null;
            currentNode.value = null;
            currentNode = nextNode;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}