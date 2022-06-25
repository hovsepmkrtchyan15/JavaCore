package chapters.chapter3;

public class Average {
    public static void main(String[] args) {
        double[] nums = {10.8, 12.2, 13.9, 15.8, 7.9};
        double resum = 0;
        int i;
        for (i = 0; i < 4; i++) ;
        {
            resum = resum + nums[i];
        }
        System.out.println("среднее значения равно " + resum / 5);


    }
}
