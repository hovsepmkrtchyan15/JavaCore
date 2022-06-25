package chapters.chepter5;

public class Switch {
    public static void main(String[] args) {
        int month = 8;
        String season;
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "зима";
                break;
            case 3:
            case 4:
            case 5:
                season = "весна";
                break;
            case 6:
            case 7:
            case 8:
                season = "лета";
            case 9:
            case 10:
            case 11:
                season = "осень";
                break;
            default:
                season = "нет такого";

        }
        System.out.println(season);
    }
}
