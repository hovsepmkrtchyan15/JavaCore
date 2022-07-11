package chapters.chapter12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker {
}

public class Marker {
    @MyMarker
    public static void myMarker() {
        Marker ob = new Marker();
        try {
            Method m = ob.getClass().getMethod("myMarker");
            if (m.isAnnotationPresent(MyMarker.class)) {
                System.out.println("Маркерная анотация присутствует");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("метод не найден");
        }

    }

    public static void main(String[] args) {
        myMarker();
    }
}
