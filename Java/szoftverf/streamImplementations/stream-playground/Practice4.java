import countries.Country;
import countries.CountryRepository;
import countries.Region;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Practice4 {
    public static void main(String[] args) {
        List<Country> countries = new CountryRepository().getAll();

        TaskRunner.runCurrentTask(Practice4.class, countries);
    }

    // 1. Returns the longest country name translation:
    public static void feladat1(List<Country> countries){
        countries.stream()
                .flatMap(country -> country.translations().values().stream())
                .max(Comparator.comparing(String::length)).ifPresent(System.out::println);
    }

    // 2. Returns the longest Farsi (i.e., `"fa"`) country name translation:
    public static void feladat2_eredeti(List<Country> countries){
        countries.stream()
                .map(country -> country.translations().get("fa"))
                .filter(Objects::nonNull)
                .max(Comparator.comparing(String::length)).ifPresent(System.out::println);
    }

    // 3. Prints the longest country name translation together with its language code in the form language=translation:
    public static void feladat3 (List<Country> countries){
        countries.stream()
                .map(country -> country.translations().get("fa"))
                .forEach(System.out::println);
    }

    // 4. Prints single-word country names (i.e., country names that do not contain any space characters):
    public static void feladat4 (List<Country> countries){
        countries.stream()
                .filter(country -> !country.name().contains(" "))
                .map(Country::name)
                .forEach(System.out::println);
    }

    // 5. Returns the country name with the most number of words:
    public static Optional<String> feladat5 (List<Country> countries){
        return countries.stream()
                .map(Country::name)
                .map(name -> name.split(" "))
                .max(Comparator.comparingInt(Array::getLength))
                .map(name -> String.join(" ",name));
    }

    // 6. Returns whether at least one capital that is a palindrome exists:
    public static boolean feladat6(List<Country> countries){
        return countries.stream()
                .filter(country -> country.capital() != null)
                .anyMatch(country -> country.capital().toLowerCase().charAt(0) == country.capital().charAt(country.capital().length()-1));
    }

    // 11. Returns the number of country names by region that starts with their two-letter country code ignoring case:
    public static Map<Region, Long> feladat11(List<Country> countries){
        return countries.stream()
                .collect(
                        groupingBy(
                                Country::region, // classifier (by region)
                                filtering( // downstream
                                        country -> country.name().toLowerCase().startsWith(country.code().toLowerCase()), // predicate (starts with their two-letter country code ignoring case)
                                        Collectors.counting() // downstream (number of)
                                )
                        )
                );
    }

    // 12. Returns a map containing the number of countries whose population is greater or equal to the population average versus the number of countries with a population below the average:
    public static Map< Boolean, Long> feladat12(List<Country> countries){
        Double avgPop = countries.stream()
                .mapToDouble(Country::population)
                .average().getAsDouble();

        return countries.stream()
                .collect(
                        Collectors.partitioningBy(
                                country -> country.population() >= avgPop, // predicate
                                Collectors.counting() // downstream
                        )
                );
    }

    // 13. Returns a map that contains for each country code the name of the corresponding country in Portuguese ("pt"):
    public static Map<String, String> feladat13(List<Country> countries){
        return countries.stream()
                .collect(
                        Collectors.toMap(
                                Country::code,
                                country -> country.translations().get("pt")
                        )
                );
    }

    // 14. Returns the list of capitals by region whose name is the same as the name of their country:
    public static  Map<Region, List<String>> feladat14(List<Country> countries){
        return countries.stream().collect(
                groupingBy(
                        Country::region,
                        filtering(
                                country -> country.name().equals(country.capital()),
                                mapping(Country::name, toList()
                                )
                        )
                )
        );
    }

    // 15. Returns a map of country name-population density pairs:
    public static  Map<String, Double> feladat_current(List<Country> countries){
//        return countries.stream().collect(toMap(Country::name, country -> (long) (country.area() == null ? Double.NaN : country.population() / country.area().doubleValue())));
        return countries.stream()
                .filter(country -> country.area() != null)
                .collect(
                toMap(
                        Country::name,
                        country -> (country.population() / country.area().doubleValue())
                )
        );
    }




}
