package FileClass;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        // file = An abstract representation of file and directory path names

        File file = new File("src/FileClass/secret_message.txt");

        if(file.exists()) {
            System.out.println("File exists");
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.isFile());
            //file.delete(); jesus
        } else {
            System.out.println("File does not exist");
        }

    }
}
