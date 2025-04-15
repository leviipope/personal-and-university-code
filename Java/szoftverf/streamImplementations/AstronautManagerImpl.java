package astronauts;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class AstronautManagerImpl implements AstronautManager{

    /**
     * A konzolra írja a még élő űrhajósok közül az első 10 legfiatalabb nevét
     * és születési dátumát. Az űrhajósok mindegyikéhez egy sort kell a konzolra
     * írni
     * <pre>név: születési_dátum</pre>
     * formában. Tipp: a {@link LocalDate} osztály implementálja a
     * {@link Comparable} interfészt.
     */
    @Override
    public void printFirstTenYoungestLivingAstronauts() {
        getAstronauts().stream()
                .filter(astronaut -> astronaut.dateOfDeath() == null)
                .sorted(Comparator.comparing(Astronaut::dateOfBirth).reversed())
                .limit(10)
                .forEach(
                        astronaut -> System.out.printf(
                                "%s : %s\n",
                                astronaut.name(),
                                astronaut.dateOfBirth()
                        )
                );

    }

    /**
     * Visszaadja a repülések számának összegét az amerikai ({@code "American"})
     * nemzetiségű űrhajósokra.
     *
     * @return a repülések számának összege az amerikai ({@code "American"})
     * nemzetiségű űrhajósokra
     */
    @Override
    public int getSumOfNumberOfFlightsForAmericanAstronauts() {
        return getAstronauts().stream()
                .filter(astronaut -> astronaut.nationality().equals("American"))
                .mapToInt(Astronaut::numberOfFlights)
                .sum();
    }


    /**
     * Visszaadja a {@code "NASA"} ügynökség űrhajósaihoz tartozó és a
     * {@code "colonel"} sztringet kisbetű-nagybetű érzéketlen módon tartalmazó
     * életrajzok közül a legrövidebbet egy {@code Optional}-be csomagolva.
     *
     * @return a {@code "NASA"} ügynökség űrhajósaihoz tartozó és a
     * {@code "colonel"} sztringet kisbetű-nagybetű érzéketlen módon
     * tartalmazó életrajzok közül a legrövidebb egy {@code Optional}-be
     * csomagolva
     */
    @Override
    public Optional<String> getShortestNASABioContainingColonel() {
        return getAstronauts().stream()
                .filter(astronaut -> astronaut.agency().equals("NASA"))
                .filter(astronaut -> astronaut.bio().toLowerCase().contains("colonel"))
                .map(Astronaut::bio)
                .min(Comparator.comparing(String::length));
    }

    /**
     * Visszaadja a már elhunyt űrhajósok számát a halálozás hónapja szerint
     * csoportosítva. Tipp: a {@link LocalDate#getMonth()} metódus
     * adja vissza egy {@link LocalDate} objektum hónapját egy
     * {@link Month} típusú objektum formájában, mint például
     * {@code Month.JUNE}.
     *
     * @return a már elhunyt űrhajósok száma a halálozás hónapja szerint
     * csoportosítva
     */
    @Override
    public Map<Month, Long> getNumberOfAstronautsByMonthOfDateOfDeath() {
        return getAstronauts().stream()
                .filter(astronaut -> astronaut.dateOfDeath() != null)
                .collect(
                        Collectors.groupingBy(
                                astronaut -> astronaut.dateOfDeath().getMonth(), // classifier
                                Collectors.counting() // downstream
                        )
                );
    }

    /**
     * Visszaadja a legtöbb szóból álló űrhajós nevet egy {@code Optional}-be
     * csomagolva. Tipp: a {@link  String#split(String)} metódus használható
     * egy sztring feldarabolására. Ha például szóközökkel elválasztott szavakra
     * kell egy {@code s} sztringet bontani, akkor az alábbi kódot
     * használhatjuk:
     * {@snippet :
     * String[] words = s.split(" ");
     *}
     * Mint látható, a {@code split()} metódus egy tömbben adja vissza a
     * szavakat.
     *
     * @return a legtöbb szóból álló űrhajós név egy {@code Optional}-be
     * csomagolva
     */
    @Override
    public Optional<String> getNameWithTheMostNumberOfWords() {
        return getAstronauts()
                .stream()
                .map(Astronaut::name)
                .map(name -> name.split(" "))
                .max(Comparator.comparing(Array::getLength))
                .map(name -> String.join(" ", name));
    }

    public static void main(String[] args) {
        var manager = new AstronautManagerImpl();
        //manager.printFirstTenYoungestLivingAstronauts();
        //System.out.println(manager.getSumOfNumberOfFlightsForAmericanAstronauts());
        //System.out.println(manager.getShortestNASABioContainingColonel());
        //System.out.println(manager.getNumberOfAstronautsByMonthOfDateOfDeath());
        System.out.println(manager.getNameWithTheMostNumberOfWords());
    }
}
