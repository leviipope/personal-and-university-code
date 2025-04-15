import countries.Country;
import countries.CountryRepository;
import countries.Region;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Practice3 {
    public static void main(String[] args) {
        List<Country> countries = new CountryRepository().getAll();

        TaskRunner.runCurrentTask(Practice3.class, countries);
    }

    // 3. Returns summary statistics about the area field:
    public static DoubleSummaryStatistics feladat3(List<Country> countries) {
        return countries.stream().
                map(Country::area).
                filter(Objects::nonNull).
                mapToDouble(BigDecimal::doubleValue).
                summaryStatistics(); // Returns a DoubleSummaryStatistics
    }

    // 5. Returns a comma-separated string of country names sorted alphabetically:
    public static String feladat5(List<Country> countries){
        return countries.stream().
                map(Country::name).
                sorted().
                collect(Collectors.joining(", "));
    }

    // 6. Returns the map of country code-country name pairs:
    public static Map<String, String> feladat6(List<Country> countries){
        return countries.stream()
                .collect(toMap(Country::code, Country::name));
    }

    // 9. Returns the number of European and non-European countries:
    public static Map<Boolean, Long> feladat9(List<Country> countries){
        return countries.stream()
                .collect(partitioningBy(country -> country.region() == Region.EUROPE, counting()));
    }

    // 10. Returns the lists of countries by region:
    public static Map<Region, List<Country>> feladat10(List<Country> countries){
        return countries.stream()
                .collect(
                        groupingBy(
                                Country::region
                        )
                );
    }

    // 11. Returns the number of countries by region:
    public static Map<Region, Long> feladat11(List<Country> countries){
        return countries.stream()
                .collect(
                        groupingBy(
                                Country::region,
                                counting()
                        )
                );
    }

    // 12. Prints the number of countries by region:
    public static void feladat12(List<Country> countries){
        countries.stream()
                .collect(
                        groupingBy(
                                Country::region,
                                counting()
                        )
                )
                .forEach((region, count) -> System.out.printf("%s -> %d || ", region, count));
    }

    public static void feladat12_5(List<Country> countries){
        countries.stream().
                collect(groupingBy(Country::region, counting())).
                entrySet().
                stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                forEach(System.out::println);
    }

    // 13. Returns population average by region:
    public static Map<Region, Double> feladat13(List<Country> countries){
        return countries.stream()
                .collect(
                        groupingBy(
                                Country::region,
                                averagingDouble(Country::population)
                        )
                );
    }

    // 14. Returns the most populous country by region:
    public static Map<Region, Optional<Country>> feladat14(List<Country> countries){
        return countries.stream()
                .collect(
                        groupingBy(
                                Country::region, // classifier
                                maxBy(Comparator.comparing(Country::population)) //downstream
                        )
                );
    }

    // 15. Returns the largest population by region:
    public static Map<Region, Optional<Long>> feladat15 (List<Country> countries){
        return countries.stream()
                .collect(
                        groupingBy(
                                Country::region,
                                mapping(
                                        Country::population,
                                        maxBy(Long::compare)
                                )
                        )
                );
    }

    // 16. Returns the longest country name by region:
    public static Map<Region, Optional<String>> feladat16(List<Country> countries){
        return countries.stream()
                .collect(
                        groupingBy(
                            Country::region, //classifier (by region)
                            Collectors.mapping( //downstream
                                    Country::name, //mapper (country name)
                                    maxBy(Comparator.comparingInt(String::length)) //downstream (longest)
                            )
                        )
                );
    }

    // 17. Return the number of countries grouped by the first letter of their name:
    public static  Map<Character,Long> feladat17(List<Country> countries){
        return countries.stream()
                .collect(
                        groupingBy(
                                country -> country.name().charAt(0), // classifier (by the first letter of their name)
                                counting() // downstream (number of)
                        )
                );
    }

}
