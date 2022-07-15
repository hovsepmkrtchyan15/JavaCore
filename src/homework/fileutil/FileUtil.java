package homework.fileutil;

import java.io.*;
import java.util.Scanner;

class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        contentSearch();
        fileSearch();
        findLines();
        printSizeOfPackage();
        createFileWithContent();
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        boolean searchFile = false;
        String path = scanner.nextLine();
        String fileName = scanner.nextLine();
        File myfile = new File(path);
        if (myfile.isDirectory()) {
            File[] files = myfile.listFiles();
            for (File file : files) {
                if (file.getName().contains(fileName)) {
                    searchFile = true;
                }
            }
            System.out.println(searchFile);
        }
    }


    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
// 1 - path թե որ ֆոլդերում ենք փնտրելու
// 2 - keyword - ինչ որ բառ
// Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
// մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() throws IOException {
        String path = scanner.nextLine();
        String keyword = scanner.nextLine();

        File file = new File(path);
        File[] files = file.listFiles();

        for (File file1 : files) {
            if (file1.getName().endsWith(".txt")) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1.getAbsolutePath()))) {
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null){
                        if (line.contains(keyword)) {
                            System.out.println(file1.getName());
                        }
                    }
                }
            }
        }
    }


    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
// 1 - txtPath txt ֆայլի փաթը
// 2 - keyword - ինչ որ բառ
// տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() throws IOException {

        String txtPath = scanner.nextLine();
        String keyword = scanner.nextLine();

        File file = new File(txtPath);
        if (file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(txtPath))) {
                String len = "";
                while ((len = bufferedReader.readLine()) != null) {
                    if (len.contains(keyword)) {
                        System.out.println(len);
                    }
                }
            }
        }
    }


//այս մեթոդը պետք է սքաններով վերցնի մեկ string.
// 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
// ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        long len = 0;

        System.out.println("Please input file path");
        String path = scanner.nextLine();

        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            len += file1.length();
        }
        System.out.println(len);

    }


    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
// 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
// 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
// 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
// որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() throws IOException {

        String path = scanner.nextLine();
        String fileName = scanner.nextLine();
        String content = scanner.nextLine();

        File file = new File(path + "\\" + fileName);
        file.createNewFile();
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file.getPath()))) {

            out.write(content);

        }
    }
}





