package feladat2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String filePath = "konyv.json";

        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Konyv> konyvs = mapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Konyv>>(){}
            );

            konyvs.stream().forEach(System.out::println);

            System.out.println();

            konyvs.stream()
                    .filter(konyv -> konyv.getKiadasEve() > 1950)
                    .forEach(System.out::println);

            double isbnAvg = konyvs.stream()
                    .mapToDouble(Konyv::getISBN)
                    .average()
                    .orElse(0);
            System.out.println("\nisbnAvg: " + isbnAvg);

            Map<String, List<Konyv>> szerzoKonyvek = konyvs.stream()
                    .collect(Collectors.groupingBy(
                            Konyv::getSzerzo
                    ));
            szerzoKonyvek.forEach((szerzo, konyvek) ->
                    System.out.println(szerzo + ": " + konyvek));


        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
