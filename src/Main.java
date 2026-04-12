public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(30);
        list.add(2, 15);

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Index 2: " + list.get(2));
        System.out.println("Size: " + list.size());

        list.removeFirst();
        list.removeLast();
        list.set(1, 100);

        System.out.println("After changes:");
        for (Integer x : list) {
            System.out.println(x);
        }

        System.out.println("Index of 100: " + list.indexOf(100));
        System.out.println("Exists 20: " + list.exists(20));

        list.sort();
        System.out.println("After sort:");
        for (Integer x : list) {
            System.out.println(x);
        }
    }
}