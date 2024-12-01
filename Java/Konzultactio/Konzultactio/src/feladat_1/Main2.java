package feladat_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        Adatok adatok = mapper.readValue(new File("json_input.json"), Adatok.class);

        List<Etel> etels = adatok.getAdatok();


        //Streames feladat:
        //szűrés
        etels.stream().filter(e->e.getAr()>2000 && e.getEtelTipusa().equals("eloetel")).forEach(System.out::println);

        //dátum
        //Ha dátumos feladat lesz akkor csak az évre fognak rákérdezni
        etels.stream().filter(e->e.getAr()>2000 && e.getEtelTipusa().equals("eloetel") && e.getLejaratDatuma().getYear()>2023).forEach(System.out::println);

        //min/max

        System.out.println(etels.stream().min(new Comparator<Etel>() {
            @Override
            public int compare(Etel o1, Etel o2) {
                return (int)(o1.getAr()-o2.getAr());
            }
        }).map(Etel::getNev).get());
        //map-el csak az a dolgot kapjuk meg amit megadunk neki itt pl. csak a nevét fogjuk megkapni
        System.out.println(etels.stream().mapToDouble(Etel::getAr).average().getAsDouble());

        System.out.println(etels.stream().collect(Collectors.groupingBy(e-> e.getEtelTipusa())));
        //itt elég lesz ennyi, nem kell semmibe beletenni

    }
}
