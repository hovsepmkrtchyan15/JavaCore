package homework.testFolder;

import java.io.*;

public class DataIOStream {
    private static final String FILE_PATH = "C:\\Users\\Hoso\\IdeaProjects\\JavaCore\\src\\homework\\testFolder\\example.txt";

    public static void main(String[] args) throws IOException {
//        write();
        read();
    }

    public static void write() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_PATH));
        out.writeInt(553);
        out.writeBoolean(true);
        out.flush();

        out.close();
    }

    public static void read() throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(FILE_PATH));
        System.out.println(inputStream.readInt());
        System.out.println(inputStream.readBoolean());
        inputStream.close();
    }

}
