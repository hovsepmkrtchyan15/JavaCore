package homework.practice;

public class PracticeHomeworkDemo {
    public static void main(String[] args) {
        PracticeHomework myPh = new PracticeHomework();
        System.out.println(myPh.convert(14));
        System.out.println(myPh.calcAge(5));
        System.out.println(myPh.nextNumber(29));
        System.out.println(myPh.isSamNum(9, 27));
        System.out.println(myPh.lessThenOrEqualToZero(15));
        System.out.println(myPh.reverseBool(true));
        int[] array1 = {12, 73, 5, 9, 657, 32};
        int[] array2 = {12,2,33,7};
        System.out.println(myPh.maxLength(array1, array2));
    }
}
