import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private MyNode getNode(int index) {
        checkIndex(index);

        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);

        if (index == 0) {
            addFirst(item);
            return;
        }

        if (index == size) {
            addLast(item);
            return;
        }

        MyNode current = getNode(index);
        MyNode newNode = new MyNode(item);

        MyNode previous = current.prev;
        previous.next = newNode;
        newNode.prev = previous;
        newNode.next = current;
        current.prev = newNode;

        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        MyNode current = getNode(index);
        MyNode previous = current.prev;
        MyNode nextNode = current.next;

        previous.next = nextNode;
        nextNode.prev = previous;

        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }

    @Override
    public void sort() {
        if (size < 2) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;

            for (int j = 0; j < size - i - 1; j++) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;

        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }

        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode current = head;
        int i = 0;

        while (current != null) {
            result[i] = current.data;
            current = current.next;
            i++;
        }

        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}