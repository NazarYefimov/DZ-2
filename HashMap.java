class MyHashMap<K, V> {
        private Node<K, V>[] buckets;
        private int size;

        public MyHashMap(int capacity) {
                buckets = new Node[capacity];
                size = 0;
        }

        public void put(K key, V value) {
                int hashCode = key.hashCode();
                int index = hashCode % buckets.length;

                Node<K, V> existingNode = findNodeInBucket(buckets[index], key);
                if (existingNode != null) {
                        existingNode.setValue(value);
                } else {
                        Node<K, V> newNode = new Node<>(key, value);
                        newNode.setNext(buckets[index]);
                        buckets[index] = newNode;
                        size++;
                }
        }

        public V get(K key) {
                int hashCode = key.hashCode();
                int index = hashCode % buckets.length;

                Node<K, V> node = findNodeInBucket(buckets[index], key);
                return node != null ? node.getValue() : null;
        }

        public void remove(K key) {
                int hashCode = key.hashCode();
                int index = hashCode % buckets.length;

                Node<K, V> previous = null;
                Node<K, V> current = buckets[index];

                while (current != null) {
                        if (current.getKey().equals(key)) {
                                if (previous == null) {
                                        buckets[index] = current.getNext();
                                } else {
                                        previous.setNext(current.getNext());
                                }
                                size--;
                                return;
                        }
                        previous = current;
                        current = current.getNext();
                }
        }

        public void clear() {
                for (int i = 0; i < buckets.length; i++) {
                        buckets[i] = null;
                }
                size = 0;
        }

        public int size() {
                return size;
        }

        private Node<K, V> findNodeInBucket(Node<K, V> node, K key) {
                while (node != null) {
                        if (node.getKey().equals(key)) {
                                return node;
                        }
                        node = node.getNext();
                }
                return null;
        }

        private static class Node<K, V> {
                private K key;
                private V value;
                private Node<K, V> next;

                public Node(K key, V value) {
                        this.key = key;
                        this.value = value;
                        this.next = null;
                }

                public K getKey() {
                        return key;
                }

                public V getValue() {
                        return value;
                }

                public void setValue(V value) {
                        this.value = value;
                }

                public Node<K, V> getNext() {
                        return next;
                }

                public void setNext(Node<K, V> next) {
                        this.next = next;
                }
        }
}