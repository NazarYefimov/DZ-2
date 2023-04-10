class MyLinkedList<T> {
        private Node head;
        private Node tail;
        private int size;

        private class Node {
                T value;
                Node prev;
                Node next;

                public Node(T value, Node prev, Node next) {
                        this.value = value;
                        this.prev = prev;
                        this.next = next;
                }
        }

        public void add(T value) {
                Node newNode = new Node(value, tail, null);
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
                Node currentNode = getNode(index);
                Node prevNode = currentNode.prev;
                Node nextNode = currentNode.next;
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
                Node currentNode = head;
                while (currentNode != null) {
                        Node nextNode = currentNode.next;
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

        private Node getNode(int index) {
                if (index < 0 || index >= size) {
                        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
                }
                Node currentNode = head;
                for (int i = 0; i < index; i++) {
                        currentNode = currentNode.next;
                }
                return currentNode;
        }
}