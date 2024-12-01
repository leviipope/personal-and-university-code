package file_writer;

import java.io.FileWriter;
import java.io.IOException;

public class Main  {
    public static void main(String[] args) throws IOException {

        try {
            FileWriter fw = new FileWriter("src/file_writer/peom.txt");
            fw.write("roses are red");
            fw.append("\n(A peom by BROSKY)");
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
