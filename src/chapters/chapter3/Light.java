package chapters.chapter3; //Вычислить расстояние, проходимое светом,
// используя переменные типа long

public class Light {
    public static void main(String[] args) {
        int lightspeed;
        long days;
        long seconds;
        long distance;

        lightspeed = 186000;//Скорость света
        days = 1000;//указать количество дней
        seconds = days * 24 * 60 * 60;
        // Преобразавать в секунды
        distance=lightspeed*seconds;
        // Вычислить расстояние
        System.out.print("за " + days);
        System.out.print(" дней свет пройдет около ");
        System.out.println(distance + " милл");
    }
}
