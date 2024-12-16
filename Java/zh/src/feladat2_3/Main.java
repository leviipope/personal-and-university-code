package feladat2_3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // jackson.core
        // jackson.databind
        // fasterxml.jackson

        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Rendeles> rendelesList = mapper.readValue(
                    new File("rendeles.json"),
                    new TypeReference<List<Rendeles>>() {
                    }
            );

            rendelesList.stream()
                    .filter(rendelo -> rendelo.getMegrendelo().equals("Zsuzsa Kocsis") && rendelo.getOsszeg() > 15500)
                    .forEach(System.out::println);

            Rendeles legnagyobbDebreceni = rendelesList.stream()
                    .filter(rendeles -> rendeles.getCim().contains("Debrecen"))
                    .max(Comparator.comparing(Rendeles::getOsszeg))
                    .orElse(null);
            System.out.println(legnagyobbDebreceni);

            Map<String, List<Rendeles>> rendelesMap = rendelesList.stream()
                    .collect(Collectors.groupingBy(
                            Rendeles::getMegrendelo
                    ));
            rendelesMap.forEach((megrendelo, rendeles) -> {
                System.out.println(megrendelo);
                rendeles.forEach(System.out::println);
            });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
