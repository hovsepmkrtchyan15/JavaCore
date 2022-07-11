package chapters.chapter12;


import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();

    int val();
}
@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}
@MyAnno(str = "META", val = 99)
@What(description = "анотация тест")
class Meta {
    @MyAnno(str = "два параметра", val = 19)
    @What(description = "анотация метода")
    public static void myMeth() {
        Meta ob = new Meta();
        try {
            Annotation[] annos = ob.getClass().getAnnotations();
            System.out.println("все анотации класа");
            for (Annotation a : annos) {
                System.out.println(a);
            }
            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();
            System.out.println("все анотации метода");
            for (Annotation a : annos) {
                System.out.println(a);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }

    }public static void main(String[] args) {
        myMeth();


    }

}