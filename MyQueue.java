class MyQueueNode<T> implements MyQueue<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public MyQueueNode() {
                head = null;
                tail = null;
                size = 0;
        }

        public void add