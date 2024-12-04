package feladat1_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<Orvos> orvosok = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("orvos_input.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(";");
                orvosok.add(new Orvos(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4])));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        HashSet<Orvos> orvosokSet = new HashSet<>();
        for(Orvos orvos : orvosok){
            orvosokSet.add(orvos);
        }

        //1.3.d


    }
}
