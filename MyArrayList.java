class MyArrayList<T> {

        private T[] data;
        private int size;

        public MyArrayList() {
                this.data = (T[]) new Object[10];
                this.size = 0;
        }

        public void add(T value) {
                if (size == data.length) {
                        resize();
                }
                data[size++] = value;
        }

        public T remove(int index) {
                T removedValue = data[index];
                System.arraycopy(data, index + 1, data, index, size - index - 1);
                data[--size] = null;
                return removedValue;
        }

        public void clear() {
                Arrays.fill(data, null);
                size = 0;
        }

        public int size() {
                return size;
        }

        public T get(int index) {
                if (index < 0 || index >= size) {
                        throw new IndexOutOfBoundsException("Index out of range: " + index);
                }
                return data[index];
        }

        private void resize() {
                T[] newData = (T[]) new Object[data.length * 2];
                System.arraycopy(data, 0, newData, 0, data.length);
                data = newData;
        }
}