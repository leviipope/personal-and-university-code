import countries.Country;
import countries.CountryRepository;
import countries.Region;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

public class Practice2 {
    public static void main(String[] args) {
        List<Country> countries = new CountryRepository().getAll();

        TaskRunner.runCurrentTask(Practice2.class, countries);
    }

    // 1. Returns whether there is at least one country with the word "island" in its name, ignoring case:
    public static boolean feladat1(List<Country> countries){
        return countries.stream()
                .anyMatch(country -> country.name().toLowerCase().contains("island"));
    }

    // 2. Returns the first country name that contains the word "island", ignoring case:
    public static void feladat2(List<Country> countries){
        countries.stream()
                .filter(country -> country.name().toLowerCase().contains("island"))
                .map(Country::name)
                .limit(1)
                .forEach(System.out::println);
    }

    public static void feladat2_eredeti(List<Country> countries){
        countries.stream().
                map(Country::name).
                filter(s -> s.toLowerCase().contains("island")).
                findFirst()
                .stream()
                .forEach(System.out::println);

    }

    // 3. Prints each country name in which the first and the last letters are identical, ignoring case:
    public static void feladat3(List<Country> countries){
        countries.stream()
                .filter(country -> country.name().toLowerCase().charAt(0) == country.name().toLowerCase().charAt(country.name().length()-1))
                .map(Country::name)
                .forEach(System.out::println);
    }

    public static void feladat3_eredeti(List<Country> countries){
        countries.stream().
                map(Country::name).
                filter(s -> {
                    String t = s.toLowerCase();
                    return t.charAt(0) == t.charAt(t.length() - 1);
                }).
                forEach(System.out::println);
    }

    // 4. Prints the populations of the first ten least populous countries | req: maptolong, sorted, limit
    public static void feladat4(List<Country> countries){
        countries.stream()
                .mapToLong(Country::population)
                .sorted()
                .limit(10)
                .forEach(System.out::println);
    }

    // 5. Prints the names of the first ten least populous countries | req: sorted, limit
    public static void feladat5(List<Country> countries){
        countries.stream()
                .sorted(Comparator.comparing(Country::population))
                .map(Country::name)
                .limit(10)
                .forEach(System.out::println);
    }

    // 6. Returns summary statistics about the number of country name translations associated with each country
    public static IntSummaryStatistics feladat6 (List<Country> countries) {
        return countries.stream()
                .mapToInt(country -> country.translations().size())
                .summaryStatistics();
    }

    // 8. Prints the number of time zones for each country in the form name:timezones, in the ascending order of the number of time zones:
    public static void feladat8(List<Country> countries){
        countries.stream()
                .sorted(Comparator.comparing(country -> country.timezones().size()))
                .forEach(country -> System.out.printf(
                                "%s:%d\n",
                                country.name(),
                                country.timezones().size()
                        )
                );
    }

    // 9. Returns the number of countries with no Farsi country name translation (the Farsi language is identified by the language code "fa"):
    public static long feladat9(List<Country> countries){
        return countries.stream()
                .filter(country -> !country.translations().containsKey("fa"))
                .count();
    }

    // 10. Prints the names of countries with null area:
    public static void feladat10(List<Country> countries){
        countries.stream()
                .filter(country -> country.area() == null)
                .map(Country::name)
                .forEach(System.out::println);
    }

    // 11. Prints all distinct language tags of country name translations sorted in alphabetical order
    public static void feladat11(List<Country> countries) {
        countries.stream().
                flatMap(country -> country.translations().keySet().stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    // 12. Returns the average length of country names:
    public static Double feladat12(List<Country> countries) {
        return countries.stream()
                .map(Country::name)
                .mapToInt(String::length)
                .average()
                .getAsDouble();
    }

    // 13. Prints all distinct regions of the countries with null area:
    public static void feladat13(List<Country> countries) {
        countries.stream()
                .filter(country -> country.area() == null)
                .map(Country::region)
                .distinct()
                .forEach(System.out::println);
    }

    // 14. Returns the largest country with non-null area:
    public static Country feladat14(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.area() != null)
                .max(Comparator.comparing(Country::area))
                .get();
    }

    // 15. Prints the names of countries with a non-`null` area below 1:
    public static void feladat15(List<Country> countries) {
        countries.stream()
                .filter(country -> country.area() != null)
                .filter(country -> country.area().compareTo(BigDecimal.ONE) < 0)
                .map(Country::name)
                .forEach(System.out::println);
    }

    // 16. Prints all distinct time zones of European and Asian countries | req: flatmap
    public static void feladat_current(List<Country> countries) {
        countries.stream()
                .filter(country -> country.region() == Region.EUROPE || country.region() == Region.ASIA)
                .flatMap(country -> country.timezones().stream())
                .distinct()
                .forEach(System.out::println);
    }

}






