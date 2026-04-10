public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(30);

        System.out.println(list.get(0));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.size());

        list.remove(1);
        System.out.println(list.size());

        list.sort();

        for (Integer x : list) {
            System.out.println(x);
        }
    }
}