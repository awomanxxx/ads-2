public class Main {
    public static void main(String[] args) {

        System.out.println("----MyArrayList Test: ");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.addFirst(5);
        arrayList.addLast(30);
        arrayList.add(2, 15);

        System.out.println("First element: " + arrayList.getFirst());
        System.out.println("Last element: " + arrayList.getLast());
        System.out.println("Element at index 2: " + arrayList.get(2));
        System.out.println("Size: " + arrayList.size());

        arrayList.remove(1);
        arrayList.set(1, 100);
        arrayList.sort();

        System.out.println("ArrayList after changes:");
        for (Integer item : arrayList) {
            System.out.println(item);
        }

        System.out.println("Index of 100: " + arrayList.indexOf(100));
        System.out.println("Exists 30: " + arrayList.exists(30));


        System.out.println("\n----MyLinkedList Test: ");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.addFirst(5);
        linkedList.addLast(30);
        linkedList.add(2, 15);

        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
        System.out.println("Element at index 2: " + linkedList.get(2));
        System.out.println("Size: " + linkedList.size());

        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.set(1, 100);
        linkedList.sort();

        System.out.println("LinkedList after changes:");
        for (Integer item : linkedList) {
            System.out.println(item);
        }

        System.out.println("Index of 100: " + linkedList.indexOf(100));
        System.out.println("Exists 20: " + linkedList.exists(20));


        System.out.println("\n----MyStack Test: ");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Size after pop: " + stack.size());


        System.out.println("\n MyQueue Test:");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Size after dequeue: " + queue.size());


        System.out.println("\n-----MyMinHeap Test: ");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);

        System.out.println("Minimum element: " + heap.getMin());
        System.out.println("Extracted minimum: " + heap.extractMin());
        System.out.println("New minimum: " + heap.getMin());
        System.out.println("Heap size: " + heap.size());
    }
}