package chapters.chepter5;

public class Search {
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 90, 65, 7, 9};
        int val=5;
        boolean found=false;
        for(int x: nums){
            if(val==nums[x]){
                found=true;
                break;
            }
        }
        if(found){
            System.out.println("Знaчeниe найдено!");
        }
    }
}
