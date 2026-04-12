public class MyMinHeap <T extends Comparable<T>>{
    private MyArrayList<T> heap;
    public MyMinHeap() {
        heap = new MyArrayList<>();

    }
    public void insert(T item) {
        heap.addLast(item);
        heapifyUp(heap.size()-1);
    }
    public T getMin(){
        if (isEmpty()){
            throw new RuntimeException("Heap is empty");

        }
        return heap.get(0);

    }
    public T extractMin() {
        if (isEmpty()){
            throw new RuntimeException("Heap is empty");
        }
        T min = heap.get(0);
        if (heap.size() == 1)
            heap.removeLast();
        return min;
    }
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

}
