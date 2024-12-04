package feladat1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        String konyvFajl = args[0];

        ArrayList<Konyv> konyvs = new ArrayList<>();

        try(Scanner sc = new Scanner(new File(konyvFajl))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(";");
                konyvs.add(new Konyv(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Konyv> filteredKonyvek = legutobbiKonyvek(konyvs, 1950 );
        Collections.sort(filteredKonyvek, new Comparator<>() {
            @Override
            public int compare(Konyv o1, Konyv o2) {
                int v = o1.getKiadasEve()-o2.getKiadasEve();
                if(v!=0) return v;
                return o1.getCim().compareTo(o2.getCim());
            }
        });
        for(Konyv konyv : filteredKonyvek){
            System.out.println(konyv);
        }
    }

    public static List<Konyv> legutobbiKonyvek(List<Konyv> konyvek, int ev){
        List<Konyv> filteredKonyvek = new ArrayList<>();
        for(Konyv konyv : konyvek){
            if(konyv.getKiadasEve() > ev){
                if(konyv.getSzerzo().charAt(0) == 'T'){
                    filteredKonyvek.add(konyv);
                }
            }
        }
        return filteredKonyvek;
    }
}
