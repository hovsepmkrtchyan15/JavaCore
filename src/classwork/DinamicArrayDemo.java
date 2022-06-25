package classwork;

public class DinamicArrayDemo {
    public static void main(String[] args) {
        DinamicArray da = new DinamicArray();
        da.add(3);
        da.add(8);
        da.add(12);
        da.add(9);
        da.add(7);
        da.add(23);
        da.add(57);
        da.add(57);
        da.add(57);
        da.add(57);
        da.print();
        System.out.println();
        System.out.println(da.isEmpty());
        System.out.println(da.getByIndex(9));
        System.out.println(da.getFirstIndexByValue(7));
        da.set(3, 44);
        da.print();
        System.out.println();
        da.add(5, 12);
        System.out.println();
        da.print();
        System.out.println();
        da.delete(3);
        da.print();



    }
}
