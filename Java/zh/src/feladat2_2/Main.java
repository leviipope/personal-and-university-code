package feladat2_2;

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

            konyvs.stream()
                    .filter(konyv -> konyv.getSzerzo().equals("Fyodor Dostoevsky"))
                    .forEach(System.out::println);

            Konyv biggestISBN = konyvs.stream()
                    .max(Comparator.comparing(Konyv::getISBN))
                    .orElse(null);
            System.out.println(biggestISBN);

            Map<String, List<Konyv>> booksGroupedByGenre = konyvs.stream()
                    .collect(Collectors.groupingBy(
                            Konyv::getMufaj
                    ));

            booksGroupedByGenre.forEach((genre, books) -> {
                System.out.println("Genre: " + genre);
                books.forEach(System.out::println);
                System.out.println();
            });

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
