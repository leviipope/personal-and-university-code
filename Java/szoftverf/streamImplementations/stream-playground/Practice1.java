import countries.Country;
import countries.CountryRepository;
import countries.Region;

import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;

public class Practice1 {
    public static void main(String[] args) {
        List<Country> countries = new CountryRepository().getAll();

        feladat26(countries);
        //System.out.println(feladat24(countries));

    }

    // 1. Prints country names:
    public static void feladat1(List<Country> countries) { //hogy ne kelljen peldanyositani  a main t
        countries.stream()
                .map(Country::name)
                .forEach(System.out::println);
    }

    // 2. Prints the capital of each country in alphabetical order:
    public static void feladat2(List<Country> countries) {
        countries.stream()
                .map(Country::capital)
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }

    // 3. Prints the capital of each country in reverse alphabetical order:
    public static void feladat3(List<Country> countries) {
        countries.stream()
                .map(Country::capital)
                .sorted(Comparator.nullsFirst(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    // 4. Returns the maximum population:
    public static Long feladat4(List<Country> countries) {
        return countries.stream()
                .mapToLong(country -> country.population())
                .max()
                .getAsLong(); //long formaban add vissza
    }

    // 5. Returns population average:
    public static Double feladat5(List<Country> countries) {
        return countries.stream()
                .mapToDouble(Country::population)
                .average()
                .getAsDouble();
    }

    // 6. Returns summary statistics about the population field
    public static LongSummaryStatistics feladat6(List<Country> countries) {
        return countries.stream()
                .mapToLong(Country::population)
                .summaryStatistics();//keszit egy osszegzo statisztikat
    }

    // 7. Prints the names of European countries
    public static void feladat7(List<Country> countries) {
        countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .map(Country::name)
                .forEach(System.out::println);
    }

    // 8. Returns the number of European countries:
    public static long feladat8(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .count();
    }

    // 9. Returns the number of independent countries:
    public static long feladat9(List<Country> countries) {
        return countries.stream()
                .filter(Country::independent)
                .count();
    }

    // 10. Prints all countries with a population below 100:
    public static void feladat10(List<Country> countries) {
        countries.stream()
                .filter(country -> country.population() < 100)
                .map(Country::name)
                .forEach(System.out::println);
    }

    // 12. Returns the sum of the population of European countries:
    public static long feladat12(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .mapToLong(Country::population)
                .sum();
    }

    // 13. Prints the population of European countries in ascending order:
    public static void feladat13(List<Country> countries) {
        countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .mapToLong(Country::population)
                .sorted()
                .forEach(System.out::println);
    }

    // 14. Prints the population of European countries in descending order:
    public static void feladat14(List<Country> countries) {
        countries.stream().
                filter(country -> country.region() == Region.EUROPE).
                mapToLong(Country::population).
                boxed(). // returns a Stream of java.lang.Long objects (required because LongStream has only a no-argument sorted() operation)
                sorted(Comparator.reverseOrder()).
                forEach(System.out::println);
    }

    // 15. Returns the European country with the highest population:
    public static void feladat15(List<Country> countries) {
        countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .max(Comparator.comparingLong(Country::population))
                .ifPresent(System.out::println);
    }

    // 16. Returns the name of the European country with the highest population:
    public static void feladat16(List<Country> countries) {
        countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .max(Comparator.comparingLong(Country::population))
                .map(Country::name)
                .ifPresent(System.out::println); // Directly print if exists
    }

    // 17. Prints the names of the first five countries:
    public static void feladat17(List<Country> countries) {
        countries.stream()
                .map(Country::name)
                .limit(5)
                .forEach(System.out::println);
    }

    // 18. Returns whether there is at least one country with zero population:
    public static boolean feladat18(List<Country> countries) {
        return countries.stream()
                .anyMatch(country -> country.population() == 0);
    }

    // 19. Returns whether each country has at least one time zone:
    public static boolean feladat19(List<Country> countries) {
        return countries.stream()
                .noneMatch(country -> country.timezones().isEmpty());
    }

    // 20. Returns the first country whose name starts with ‘H’:
    public static Country feladat20(List<Country> countries) {
        return countries.stream()
                .filter(country -> country.name().charAt(0)=='H')
                .findFirst()
                .get();
    }

    // 21. Returns the number of all distinct time zones:
    public static long feladat21(List<Country> countries) {
        return countries.stream()
                .flatMap(country -> country.timezones().stream())
                .distinct()
                .count();
    }

    // 22. Prints all distinct time zones of European countries:
    public static void feladat22(List<Country> countries) {
        countries.stream()
                .filter(country -> country.region() == Region.EUROPE)
                .flatMap(country -> country.timezones().stream())
                .distinct()
                .forEach(System.out::println);
    }

    // 23. Prints the name and population of each country in descending order of population:
    public static void feladat23(List<Country> countries) {
        countries.stream()
                .sorted(Comparator.comparingLong(Country::population).reversed())
                .forEach(country -> System.out.printf(
                        "%s: %d\n",
                        country.name(),
                        country.population()
                ));
    }

    // 24. Returns the length of the longest country name:
    public static int feladat24(List<Country> countries) {
        return countries.stream().
                map(Country::name).
                max(Comparator.comparingInt(String::length))
                .get()
                .length();
    }

    // 25. Prints the capital of each country in ascending order of length:
    public static void feladat25(List<Country> countries) {
        countries.stream()
                .map(Country::capital)
                .sorted(Comparator.nullsFirst(Comparator.comparingInt(String::length)))
                .forEach(System.out::println);
    }

    // 26. Prints the capital of each country in ascending order of length and then in alphabetical order:
    public static void feladat26(List<Country> countries) {
        countries.stream().
                map(Country::capital)
                .sorted(Comparator.nullsFirst(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()))).
                forEach(System.out::println);
    }
}

