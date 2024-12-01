import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String etelFajl = null;
        for(int i = 0;i<args.length;i++) {
            etelFajl = args[i];
        }

        ArrayList<Etel> etelArrayList = new ArrayList<>();

        //parancsori/filebol
        try(Scanner sc = new Scanner(new File(etelFajl))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] elemek = line.split(";");
                etelArrayList.add(new Etel(elemek[0], elemek[1], Double.parseDouble(elemek[2]),
                        LocalDate.parse(elemek[3], DateTimeFormatter.ofPattern("yyyy.MM.dd")),elemek[4]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // stantard
        /*
        Scanner sc = new Scanner(System.in);
        String v;
        System.out.println("kerek eteleket, ;-vel elvalasztva");
        for(int i = 0; i<2; i++){
            v=sc.nextLine();
            String[] elemek = v.split(";");
            etelArrayList.add(new Etel(elemek[0], elemek[1], Double.parseDouble(elemek[2]),
                    LocalDate.parse(elemek[3], DateTimeFormatter.ofPattern("yyyy.MM.dd")),elemek[4]));
        }
        */

        //peldanyositas
        etelArrayList.add(new Etel("gulyasleves","01",10,
                LocalDate.parse("2024.12.12",DateTimeFormatter.ofPattern("yyyy.MM.dd")),"leves"));

        // Tarolas

        // List
        List<Etel> etelList = new ArrayList<>();
        for(Etel etel : etelArrayList) {
            etelList.add(etel);
        }

        // TreeSet
        TreeSet<Etel> etelTreeSet = new TreeSet<>(new Comparator<Etel>() {
            @Override
            public int compare(Etel o1, Etel o2) {
                return o1.getNev().compareTo(o2.getNev());
            }
        });
        for(Etel etel : etelArrayList) {
            etelTreeSet.add(etel);
        }

        // HashSet
        HashSet<Etel> etelHashSet = new HashSet<>();
        for(Etel etel : etelTreeSet) {
            etelHashSet.add(etel);
        }

        // HashMap
        HashMap<String, ArrayList<Etel>> etelHashMap = new HashMap<>();
        for(Etel etel : etelArrayList) {
            ArrayList<Etel> al;
            if(etelHashMap.containsKey(etel.getEtelTipus())) {
                al = etelHashMap.get(etel.getEtelTipus());
            } else {
                al = new ArrayList<>();
            }
            al.add(etel);
            etelHashMap.put(etel.getEtelTipus(), al);
        }
    }
}