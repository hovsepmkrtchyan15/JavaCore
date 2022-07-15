package homework.testFolder;

import java.io.*;

public class FileReadAndWrite {
    private static final String FILE_PATH = "C:\\Users\\Hoso\\IdeaProjects\\JavaCore\\src\\homework\\testFolder\\example.txt";

    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    public static void write() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("Hello java \r\n");
            bw.write("Hello java line 2");
        }


    }

    public static void read() throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line = "";
//            while ((line = inputStream.readLine()) != null) {
//                System.out.println(line);
            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}


