package homework.dateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class DateTest {
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public static void main(String[] args) throws ParseException {
        System.out.println("Please input date by dd-MM-yyyy format");
        String dateStr = scanner.nextLine();
        try {
            Date date =sdf.parse(dateStr);
            System.out.println(date);
        }catch (ParseException e){
            System.out.println("Please inpet date dd-MM-yyyy");
        }





    }
}
