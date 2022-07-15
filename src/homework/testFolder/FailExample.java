package homework.testFolder;

import java.io.File;
import java.io.IOException;

public class FailExample {
    static  String filepath = "C:\\Users\\Hoso\\IdeaProjects\\JavaCore\\src\\homework\\testFolder";
    public static void main(String[] args) throws IOException {
        File myFile = new File(filepath);
        System.out.println(myFile.exists());
        if(!myFile.exists()){
            myFile.createNewFile();
            System.out.println(myFile.exists());

        }
        System.out.println("isFile: " + myFile.isFile());
        System.out.println("isdirectory: " + myFile.isDirectory());
        if(myFile.isDirectory()){
            File[] files = myFile.listFiles();
            for (File file : files) {
                System.out.println(file.getName());

            }
        }
    }
}

