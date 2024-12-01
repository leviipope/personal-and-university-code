package feladat_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException ,EtelException{
        //lesz olyan feladatat,ahol példányosítunk és megvagyunk
        //lesz olyan feladatat,ahol standard input
        //lesz olyan feladatat, ahol fájból kell beolvasni
        //lesz olyan feladatat, ahol parancssoriargumentumból kell beolvasni


        //lesz olyan feladatat, ahol parancssoriargumentumból kell beolvasni / lesz olyan feladatat, ahol fájból kell beolvasni:
        String etelFajl=null;

        for (int i = 0; i < args.length; i++) {
            etelFajl=args[i];
        }

        ArrayList<Etel> etelArrayList = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(etelFajl))){
            while (sc.hasNext()){
                String line = sc.nextLine();
                String[] elemek = line.split(";");
                etelArrayList.add(new Etel(elemek[0],elemek[1],Double.parseDouble(elemek[2]),
                        LocalDate.parse(elemek[3], DateTimeFormatter.ofPattern("yyyy.MM.dd")),elemek[4]));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //lesz olyan feladatat,ahol standard inputról olvasunk be adatokat:

        /*
        Scanner sc1 = new Scanner(System.in);

        String v;
        System.out.print("Kérek egy ételt: ");
        for (int i = 0; i < 2; i++) {
            v=sc1.nextLine();
            String[] elemek = v.split(";");
            etelArrayList.add(new Etel(elemek[0],elemek[1],Double.parseDouble(elemek[2]),
                    LocalDate.parse(elemek[3], DateTimeFormatter.ofPattern("yyyy.MM.dd")),elemek[4]));

        }
        */
        //lesz olyan feladatat,ahol példányosítunk és megvagyunk:

        etelArrayList.add(new Etel("paradicsom leves","009",5000.0,LocalDate.parse("2024.12.15",DateTimeFormatter.ofPattern("yyyy.MM.dd")),"leves"));

        //Most hozzá kell majd adni egy kollekcióhoz (bármelyik kollekcióhoz hozzá kell tudni adni)

        //Listához való hozzáadás
        List<Etel> eteList = new ArrayList<>();
        for (Etel etel : eteList) {
            eteList.add(etel);
        }

        //TreeSet-hez való hozzáadás

        TreeSet<Etel> etelTreeSet = new TreeSet<>(new Comparator<Etel>() {
            @Override
            public int compare(Etel o1, Etel o2) {
                return o1.getNev().compareTo(o2.getNev());
            }
        });
        for (Etel etel : etelArrayList) {
            etelTreeSet.add(etel);
        }


        //HasSethez való hozzáadás:
        HashSet<Etel> etelHashSet = new HashSet<>();
        for (Etel etel : etelArrayList) {
            etelHashSet.add(etel);
        }

        //HasMaphoz való hozzáadás:
        HashMap<String, ArrayList<Etel>> etelHasMap = new HashMap<>();

        for (Etel etel : etelArrayList) {
            ArrayList<Etel> al;
            if (etelHasMap.containsKey(etel.getEtelTipusa())){
                al=etelHasMap.get(etel.getEtelTipusa());
            }else {
                al=new ArrayList<>();
            }
            al.add(etel);
            etelHasMap.put(etel.getEtelTipusa(),al);
        }

        //ArrayList tartalmának kiírása
        for (Etel etel : etelArrayList) {
            System.out.println(etel);
        }

        //Mapek tartalmának kiírása
        for(Map.Entry<String, ArrayList<Etel>> entry : etelHasMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        //Statikus metódusokat megírása main/runner osztályban
        //műveleteket fognak elvégezni
        //legolcsóbb, legdrágább,átlag,valaminél olcsóbb elemek, dátumra szűrés meg hasonlók

        //Rendezzük az elemeket

        List<Etel> dragaEtelek = dragaEtel(etelArrayList);

        Collections.sort(dragaEtelek, new Comparator<Etel>() {
            @Override
            public int compare(Etel o1, Etel o2) {
                int v= (int)(o1.getAr()-o2.getAr());
                if (v!=0){
                    return v;
                }
                return o1.getNev().compareTo(o2.getNev());
            }
        });

        //Ha külön osztályba van megírva a comparator
        Collections.sort(dragaEtelek,new EtelComparator());

        //Kiiratás

        ArrayList<Etel> olcsoEsDragaEtelek = olcsoEsDragaEtelek(etelArrayList);

        try(Formatter formatter = new Formatter(new File("etel-output.txt"))){
            formatter.format("Legolcsóbb: %s\n",olcsoEsDragaEtelek.get(0).getNev());
            formatter.format("Legolcsóbb: %s\n",olcsoEsDragaEtelek.get(0).getAr());
            formatter.format("Legdragabb: %s\n",olcsoEsDragaEtelek.get(1).getNev());
            formatter.format("Legdragabb: %s\n",olcsoEsDragaEtelek.get(1).getAr());
        }catch (FileNotFoundException e){
            throw  new RuntimeException(e);
        }


    }

    //Statikus metódusokat megírása main/runner osztályban
    //műveleteket fognak elvégezni
    //legolcsóbb, legdrágább,átlag,valaminél olcsóbb elemek, dátumra szűrés meg hasonlók
    //meg lesz adva mi lesz a visszatérési érték

    public static List<Etel> dragaEtel(ArrayList<Etel> etels){
        double osszeg=0;

        for(Etel etel : etels){
            osszeg+=etel.getAr();
        }
        List<Etel> etelList = new ArrayList<>();
        for(Etel etel : etels){
            if (etel.getAr()>osszeg/etels.size()){
                etelList.add(etel);
            }
        }
        return etelList;
    }

    //min vagy max:
    public static ArrayList<Etel> olcsoEsDragaEtelek(ArrayList<Etel> etels){
        double min=Double.MAX_VALUE;
        double max=Double.MIN_VALUE;

        for(Etel etel : etels){
            if (etel.getAr()<min){
                min=etel.getAr();
            }
            if (etel.getAr()>max){
                max=etel.getAr();
            }
        }
        ArrayList<Etel> etelList = new ArrayList<>();
        for(Etel etel : etels){
            if (etel.getAr()==min){
                etelList.add(etel);
            }
            if (etel.getAr()==max){
                etelList.add(etel);
            }
        }
        return etelList;
    }

    //Éves összehasonlítás



}