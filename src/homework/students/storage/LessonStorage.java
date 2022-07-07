package homework.students.storage;


import homework.students.exception.LessonNotFoundException;
import homework.students.model.Lesson;

public class LessonStorage {
    private Lesson[] array = new Lesson[10];
    private int size = 0;


    public void add(Lesson lesson) {
        if (size == array.length) {
            increaeArray();
        }
        array[size++] = lesson;

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void increaeArray() {
        Lesson[] temp = new Lesson[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }


    public int getSize() {

        return size;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("invalid index");
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }

    }


    public Lesson getLessonByIndex(int lessonIndex) throws LessonNotFoundException {
        if (lessonIndex < 0 || lessonIndex >= size) {
            throw new LessonNotFoundException("Lesson whit " + lessonIndex + " dose not exists");
        }
        return array[lessonIndex];
    }
}
