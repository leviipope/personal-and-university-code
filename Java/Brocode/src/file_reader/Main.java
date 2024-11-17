package file_reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        // FileReader = read the contents of a file as a stream on characters. One by one
        //              read() returns an int value which contain the byte value
        //              when read() return -1, there is no more data to be read

        try {
            FileReader fr = new FileReader("C:\\Users\\Levii\\Documents\\PersonalAndUniversityCode\\Java\\Brocode\\src\\file_reader\\txt.txt");
            int data = fr.read();
            while(data != -1){
                System.out.print((char)data);
                data = fr.read();
            }
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("I/O Error");
        }


    }
}
