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

        List<Orvos> forgalmasOrvosokList = forgalmasOrvosok(orvosokSet,"Oncology");
        Collections.sort(forgalmasOrvosokList, new Comparator<>() {
            @Override
            public int compare(Orvos o1, Orvos o2) {
                return o2.getBetegekSzama()-o1.getBetegekSzama();
            }
        });
        for(Orvos orvos : forgalmasOrvosokList){
            System.out.println(orvos);
        }

        try(Formatter formatter = new Formatter(new File("orvos_output.txt"))){
            formatter.format("Orvos neve: %s\n",forgalmasOrvosokList.get(0).getNev());
            formatter.format("Betegeinek Száma: %d",forgalmasOrvosokList.get(0).getBetegekSzama());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static List<Orvos> forgalmasOrvosok(HashSet<Orvos> orvosHashSet, String szakirany){
        List<Orvos> forgalmasOrvosok = new ArrayList<>();
        double sumBeteg = 0;
        for(Orvos orvos : orvosHashSet){
            sumBeteg += orvos.getBetegekSzama();
        }
        System.out.println("avg betegek száma: " + sumBeteg/orvosHashSet.size());
        for(Orvos orvos : orvosHashSet){
            if(orvos.getSzakirany().equals(szakirany)){
                if(orvos.getBetegekSzama()>=sumBeteg/orvosHashSet.size()){
                    forgalmasOrvosok.add(orvos);
                }
            }
        }
        return forgalmasOrvosok;
    }
}
