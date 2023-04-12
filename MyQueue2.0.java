


    class MyQueue<T> {
    private List<T> queue = new ArrayList<>();

    public MyQueue() {
    }

    public void add(T value) {
        queue.add(value);
    }

    public void clear() {
        queue.clear();
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        if (!queue.isEmpty()) {
            return queue.get(0);
        }
        return null;
    }

    public T poll() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        }
        return null;
    }
}
