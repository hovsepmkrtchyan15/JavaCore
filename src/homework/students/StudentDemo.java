package homework.students;

import homework.students.command.Commands;
import homework.students.dateUtil.DateUtil;
import homework.students.exception.LessonNotFoundException;
import homework.students.model.Lesson;
import homework.students.model.Student;
import homework.students.model.User;
import homework.students.model.UserType;
import homework.students.storage.LessonStorage;
import homework.students.storage.StudentStorage;
import homework.students.storage.UserStorage;


import java.util.Date;
import java.util.Scanner;

import static homework.students.dateUtil.DateUtil.*;

public class StudentDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();
    private static LessonStorage lessonStorage = new LessonStorage();

    private static UserStorage userStorage = new UserStorage();

    private static User currentUser = null;


    public static void main(String[] args) {
        initData();

        boolean run = true;
        while (run) {
            Commands.printloginCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case 0:
                    run = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;

            }
        }
    }

    private static void login() {
        System.out.println("Please input email, password");
        String emailPasswordStr = scanner.nextLine();
        String[] emailPassword = emailPasswordStr.split(",");
        User user = userStorage.getUserByEmail(emailPassword[0]);
        if (user == null) {
            System.out.println("user wite " + emailPassword[0] + " dose not exsists!");
        } else {
            if (user.getPassword().equals(emailPassword[1])) {
                currentUser = user;
                if (user.getUserType() == UserType.ADMIN) {
                    loginAdmin();
                } else {
                    if (user.getUserType() == UserType.USER) {
                        loginUser();
                    }

                }
            }
        }
    }

    private static void loginUser() {
        System.out.println("Welcom " + currentUser.getName());
        boolean run = true;
        while (run) {
            Commands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_ALL_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLessonName();
                    break;
                case PRINT_STUDENT_COUNT:
                    System.out.println("students count: " + studentStorage.getSize());
                    break;
                case PRINT_ALL_LESSON:
                    lessonStorage.print();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }


    private static void register() {
        System.out.println("Please input name, surname, email, password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 4) {
            System.out.println("please input correct data");
        } else {
            if (userStorage.getUserByEmail(userData[2]) == null) {
                User user = new User();
                user.setName(userData[0]);
                user.setSurname(userData[1]);
                user.setEmail(userData[2]);
                user.setPassword(userData[3]);
                user.setUserType(UserType.USER);
                userStorage.add(user);
                System.out.println("User created!");
            } else {
                System.out.println("user wite " + userData[2] + " already exsists!");
            }
        }

    }

    private static void loginAdmin() {
        System.out.println("Welcom " + currentUser.getName());
        boolean run = true;
        while (run) {
            Commands.printAdminCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_ALL_STUDENTS:
                    studentStorage.print();
                    break;
                case DELETE_STUDENT_BY_INDEX:
                    deleteByIndex();
                    int index;
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLessonName();
                    break;
                case PRINT_STUDENT_COUNT:
                    System.out.println("students count: " + studentStorage.getSize());
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLessonName();
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_ALL_LESSON:
                    lessonStorage.print();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    private static void initData() {
        User admin = new User("admin", "admin", "admin@mail.com", "admin", UserType.ADMIN);
        userStorage.add(admin);
        Lesson java = new Lesson("java", "teacher", 7, 899, stringToDate("06.05.2022"));
        Lesson mysql = new Lesson("mysql", "teacher", 7, 899, stringToDate("06.06.2022"));
        Lesson php = new Lesson("php", "teacher", 7, 899, stringToDate("06.07.2022"));
        lessonStorage.add(java);
        lessonStorage.add(mysql);
        lessonStorage.add(php);

        studentStorage.add(new Student("poxos", "poxosyan", 32, "878787", "Gyumri", java, admin, new Date()));
        studentStorage.add(new Student("petros", "petrosyan", 42, "879887", "Gyumri", php, admin, new Date()));
        studentStorage.add(new Student("martiros", "martirosyan", 26, "34347", "Gyumri", mysql, admin, new Date()));
    }

    private static void addLesson() {
        System.out.println("Please input lesson name");
        String lessonName = scanner.nextLine();
        System.out.println("Please input lesson teacherName");
        String teacherName = scanner.nextLine();
        System.out.println("Please input lesson duration by month");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input lesson price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Plaese input date (15.03.2022)");
        String dateStr = scanner.nextLine();

        Lesson lesson = new Lesson(lessonName, teacherName, duration, price, stringToDate(dateStr) );
        lessonStorage.add(lesson);

        System.out.println("lesson created!");
    }


    private static void changeStudentLessonName() {
        studentStorage.print();
        System.out.println("please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        Student student = studentStorage.getStudentByIndex(index);
        if (student == null) {
            System.out.println("Wrong index!!!");
            changeStudentLessonName();
        } else {
            if (lessonStorage.getSize() != 0) {
                lessonStorage.print();
                System.out.println("Please choose lesson index");

                Lesson lesson = null;
                try {
                    int lessonIndex = Integer.parseInt(scanner.nextLine());
                    lesson = lessonStorage.getLessonByIndex(lessonIndex);
                    student.setLesson(lesson);
                    System.out.println("lesson chaged");
                } catch (LessonNotFoundException | NumberFormatException e) {
                    System.out.println("Please input correct number or index!!!");
                    changeStudentLessonName();
                }

            }

        }

    }

    private static void printStudentsByLessonName() {
        System.out.println("Please input lesson name");
        String lessonName = scanner.nextLine();
        studentStorage.printStudentsByLessonName(lessonName);
    }

    private static void deleteByIndex() {
        studentStorage.print();
        System.out.println("please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        studentStorage.deleteByIndex(index);
    }


    private static void addStudent() {
        if (lessonStorage.getSize() != 0) {
            lessonStorage.print();
            System.out.println("Please choose lesson index");

            Lesson lesson = null;
            try {
                int lessonIndex = Integer.parseInt(scanner.nextLine());

                lesson = lessonStorage.getLessonByIndex(lessonIndex);
                System.out.println("Please input student's name");
                String name = scanner.nextLine();
                System.out.println("Please input student's surname");
                String surname = scanner.nextLine();
                System.out.println("Please input student's age");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Please input student's phoneNumber");
                String phoneNumber = scanner.nextLine();
                System.out.println("Please input student's city");
                String city = scanner.nextLine();

                Student student = new Student(name, surname, age, phoneNumber, city, lesson, currentUser, new Date());
                studentStorage.add(student);
                System.out.println("student created");
            } catch (LessonNotFoundException | NumberFormatException e) {
                System.out.println("Please choose correct number or index!!!");
                addStudent();
            }

        }
    }
}
