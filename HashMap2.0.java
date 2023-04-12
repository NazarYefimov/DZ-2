import java.util.*;

public class MyHashMap<K, V> {
    private Node<K, V>[] buckets;
    private int size;
    
    public MyHashMap() {
        this.buckets = new Node[16];
        this.size = 0;
    }
    
    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public void put(K key, V value) {
        
        int index = getBucketIndex(key);
        
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }


    public void remove(K key) {
       
        int index = getBucketIndex(key);
        
        Node<K, V> prev = null;
        Node<K, V> curr = buckets[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }
    
    public int size() {
        return size;
    }


    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> current = buckets[bucketIndex];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }