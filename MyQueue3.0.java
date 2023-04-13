class MyQueue<T> {
    private Node<T> head; 
    private Node<T> tail; 
    private int size; 


    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

  
    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) { 
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; 
            tail = newNode; 
        }
        size++; 
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.value;
    }

    public T poll() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = head.value;
        head = head.next;
        size--; 
        return value;
    }
}