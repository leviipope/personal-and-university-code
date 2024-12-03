package feladat5_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Szak infoTech = new Szak("Informatics","INF001",6);
        Szak mechanicalEng = new Szak("Mechanical Engineering", "ME002", 8);
        Szak businessAdmin = new Szak("Business Administration", "BA003", 7);
        Szak bioTech = new Szak("Biotechnology", "BT004", 6);
        Szak civilEng = new Szak("Civil Engineering", "CE005", 7);

        List<Hallgato> hallgatok = new ArrayList<Hallgato>();

        hallgatok.add(new Hallgato("N12345","Anna Kovacs", infoTech));
        hallgatok.add(new Hallgato("N23456", "Balazs Toth", mechanicalEng));
        hallgatok.add(new Hallgato("N34567", "Csilla Nagy", businessAdmin));
        hallgatok.add(new Hallgato("N45678", "David Szabo", bioTech));
        hallgatok.add(new Hallgato("N56789", "Erika Horvath", civilEng));
        hallgatok.add(new Hallgato("N67890", "Ferenc Kiss", infoTech));
        hallgatok.add(new Hallgato("N78901", "Gabriella Papp", mechanicalEng));
        hallgatok.add(new Hallgato("N89012", "Hanna Farkas", businessAdmin));
        hallgatok.add(new Hallgato("N90123", "Istvan Molnar", bioTech));
        hallgatok.add(new Hallgato("N01234", "Janos Varga", civilEng));

        TreeMap<Szak, List<Hallgato>> szakMap = new TreeMap<>(Comparator.comparing(Szak::getKod));

        for(Hallgato hallgato : hallgatok) {
            Szak szak = hallgato.getSzak();
            if(!szakMap.containsKey(szak)) {
                szakMap.put(szak, new ArrayList<>());
            }
            szakMap.get(szak).add(hallgato);
        }

        for(Map.Entry<Szak, List<Hallgato>> entry : szakMap.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
