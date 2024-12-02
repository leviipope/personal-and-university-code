package feladat1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Parancsori arg
        String etelFajl = null;
        for(int i = 0;i<args.length;i++) {
            etelFajl = args[i];
        }

        ArrayList<Etel> etelArrayList = new ArrayList<>();

        // parancssori arg/filebol
        try (Scanner sc = new Scanner(new File("src/"+etelFajl))) { // ha fileobl akkor ide irjuk be a file cimet
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] elemek = line.split(";");
                etelArrayList.add(new Etel(elemek[0],elemek[1],Double.parseDouble(elemek[2]),
                        LocalDate.parse(elemek[3], DateTimeFormatter.ofPattern("yyyy.MM.dd")),elemek[4]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Standard input
        /*
        Scanner sc1 = new Scanner(System.in);
        String v;
        System.out.println("kerek egy etelt ;-vel elvalasztva");
        for(int i = 0;i<2;i++){
            v=sc1.nextLine();
            String[] elemek = v.split(";");
            etelArrayList.add(new Etel(elemek[0],elemek[1],Double.parseDouble(elemek[2]),
                    LocalDate.parse(elemek[3], DateTimeFormatter.ofPattern("yyyy.MM.dd")),elemek[4]));
        }
        */

        // manulisan
        etelArrayList.add(new Etel("paradicsom leves","009",5000.0,LocalDate.parse("2024.12.15",DateTimeFormatter.ofPattern("yyyy.MM.dd")),"leves"));



        // Tarolas

        // Lista
        List<Etel> etelList = new ArrayList<>();
        for(Etel etel : etelArrayList){
            etelList.add(etel);
        }

        // TreeSet (rendezve nev szerint)
        TreeSet<Etel> etelTreeSet = new TreeSet<>(new Comparator<Etel>() {
            @Override
            public int compare(Etel o1, Etel o2) { return o1.getNev().compareTo(o2.getNev());}
        });
        for(Etel etel : etelArrayList){
            etelTreeSet.add(etel);
        }

        // HashSet
        HashSet<Etel> etelHashSet = new HashSet<>();
        for(Etel etel : etelArrayList){
            etelHashSet.add(etel);
        }

        // HashMap
        HashMap<String, ArrayList<Etel>> etelHashMap = new HashMap<>();

        for(Etel etel : etelArrayList){
            ArrayList<Etel> al;
            if(etelHashMap.containsKey(etel.getEtelTipus())){
                al = etelHashMap.get(etel.getEtelTipus());
            } else {
                al = new ArrayList<>();
            }
            al.add(etel);
            etelHashMap.put(etel.getEtelTipus(), al);
        }
        // Map tartalmanak kiiratasa
//        for(Map.Entry<String, ArrayList<Etel>> entry : etelHashMap.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        // E1
        // Elemek rendezese (Ar szerint csokkeno majd nev abc szerint novekvo)
        List<Etel> dragaEtelek = dragaEtel(etelArrayList);
        Collections.sort(dragaEtelek, new Comparator<Etel>() {
            @Override
            public int compare(Etel o1, Etel o2) {
                int v = (int)(o1.getAr()-o2.getAr());
                if(v!=0) return v;
                return o1.getNev().compareTo(o2.getNev());
            }
        });

        // E2
        Collections.sort(dragaEtelek, new EtelComparator());
    }

    // D1 kozeli lejarat
    public static List<Etel> lejaratKozel(HashMap<String, Etel> etelek, LocalDate kozeliLejarat) {
        List<Etel> kozeliLejaratuEtelek = new ArrayList<>();

        for(Etel etel : etelek.values()){
            if(etel.getLejaratDatuma().isBefore(kozeliLejarat)){
                kozeliLejaratuEtelek.add(etel);
            }
        }
        return kozeliLejaratuEtelek;
    }

    // D2 draga etel
    public static List<Etel> dragaEtel(ArrayList<Etel> etels){
        double osszeg = 0;
        for(Etel etel : etels){
            osszeg+=etel.getAr();
        }
        List<Etel> etelList = new ArrayList<>();
        for(Etel etel : etels){
            if(etel.getAr()>osszeg/etels.size()){
                etelList.add(etel);
            }
        }
        return etelList;
    }

    // D3 olcso es draga etelek
    public static ArrayList<Etel> olcsoEsDragaEtelek(ArrayList<Etel> etels){
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for(Etel etel : etels){
            if(etel.getAr()<min){
                min = etel.getAr();
            }
            if(etel.getAr()>max){
                max = etel.getAr();
            }
        }
        ArrayList<Etel> etelList = new ArrayList<>();
        for(Etel etel : etels){
            if(etel.getAr()==min){
                etelList.add(etel);
            }
            if(etel.getAr()==max){
                etelList.add(etel);
            }
        }
        return etelList;
    }

}