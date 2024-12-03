package feladat2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Path to the JSON file
        String filePath = "crystals.json";

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file and map to List of Crystal objects
            List<Crystals> crystals = objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Crystals>>() {}
            );

            // Use forEach to print each crystal
            crystals.forEach(System.out::println);
            System.out.println();

            // Use Stream to filter and print crystals with a price higher than 250
            crystals.stream()
                    .filter(crystal -> crystal.getPrice() > 250)
                    .forEach(System.out::println);
            System.out.println();

            // Use Stream to calculate the average hardness
            double avgHardness = crystals.stream()
                    .mapToDouble(Crystals::getHardness)
                    .average()
                    .orElse(0.0);

            System.out.println("Avg Hardness: " + avgHardness);
            System.out.println();

            // Group crystals by price into a Map, with names as values
            Object Crystal;
            Map<Integer, List<String>> crystalsByPrice = crystals.stream()
                    .collect(Collectors.groupingBy(
                            Crystals::getPrice,
                            Collectors.mapping(Crystals::getName, Collectors.toList())
                    ));

            // Print the map
            crystalsByPrice.forEach((price, names) ->
                    System.out.println("Price: " + price + " -> Crystals: " + names)
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
