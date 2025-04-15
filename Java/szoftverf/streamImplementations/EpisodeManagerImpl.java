package tvshow;

import java.time.DayOfWeek;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EpisodeManagerImpl implements EpisodeManager{
    public static void main(String[] args) {
        var manager = new EpisodeManagerImpl();

        //System.out.println(manager.getSeasonsWithLongEpisodes());
        //longEpisodes();

        //System.out.println(manager.getShortestSummaryOfFirstEpisodes());
        //shortestSummary();

        //System.out.println(manager.getNumberOfRegularEpisodesByDayOfAirDate());
        //regularEpisodes();

        //System.out.println(manager.getTotalRuntimeOfEpisodesWhoseTitleContainsEwing());

        //System.out.println(manager.getNumberOfDifferentWriters());
        //differentWriters();
    }

    /**
     * Visszaadja egy növekvő sorrendbe rendezett listában az összes olyan
     * különböző évad sorszámát, melyekben van 60 percnél hosszabb epizód.
     *
     * @return egy növekvő sorrendbe rendezett listában az összes olyan
     * különböző évad sorszáma, melyekben van 60 percnél hosszabb epizód
     */
    @Override
    public List<Integer> getSeasonsWithLongEpisodes() {
        return EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.runtime() > 60)
                .sorted(Comparator.comparing(Episode::season))
                .map(Episode::season)
                .toList();
    }

    public static void longEpisodes(){
        EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.runtime() > 60)
                .sorted(Comparator.comparing(Episode::season))
                .forEach(episode ->
                        System.out.printf(
                                "%s, %s, %s\n",
                                episode.title(),
                                episode.season(),
                                episode.runtime()
                        )
                );
    }

    /**
     * Visszaadja az évadok első epizódjaihoz tartozó tartalom összefoglalók
     * közül a legrövidebbet.
     *
     * @return az évadok első epizódjaihoz tartozó tartalom összefoglalók
     * közül a legrövidebb
     */
    @Override
    public Optional<String> getShortestSummaryOfFirstEpisodes() {
        return EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.number() == 1)
                .map(Episode::summary)
                .min(Comparator.comparing(String::length));
    }

    public static void shortestSummary(){
        EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.number() == 1)
                .map(Episode::summary)
                .min(Comparator.comparing(String::length))
                .ifPresent(System.out::println);
    }

    /**
     * Visszaadja a közönséges epizódok darabszámát aszerint csoportosítva, hogy
     * a hét melyik napján adták őket. Egy epizód közönséges, ha a típusa
     * {@link Type#REGULAR}. Egy {@link LocalDate} objektumhoz a
     * {@link LocalDate#getDayOfWeek()} példányszintű metódus adja vissza, hogy a hét melyik
     * napjára esik a dátum.
     *
     * @return a közönséges epizódok száma aszerint csoportosítva, hogy a hét
     * melyik napján adták őket
     */
    @Override
    public Map<DayOfWeek, Long> getNumberOfRegularEpisodesByDayOfAirDate() {
        return EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.type() == Type.REGULAR)
                .collect(Collectors.groupingBy(
                                episode -> episode.airDate().getDayOfWeek(),
                                Collectors.counting()
                        )
                );
    }

    public static void regularEpisodes(){
        EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.type() == Type.REGULAR)
                .collect(Collectors.groupingBy(
                                episode -> episode.airDate().getDayOfWeek(),
                                Collectors.counting()
                        )
                );
    }

    /**
     * Visszaadja az összes olyan különböző stábtag számát, akik szerepköre
     * {@code "Writer"}.
     *
     * @return az összes olyan különböző stábtag száma, akik szerepköre
     * {@code "Writer"}
     */
    @Override
    public long getNumberOfDifferentWriters() {
        return  EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.guestCrew() != null)
                .flatMap(episode -> episode.guestCrew().stream())
                .filter(guest -> guest.role().equals("Writer"))
                .map(CrewMember::name)
                .distinct()
                .count();
    }

    public static void differentWriters(){
        EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.guestCrew() != null)
                .flatMap(episode -> episode.guestCrew().stream())
                .filter(guest -> guest.role().equals("Writer"))
                .map(CrewMember::name)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Visszaadja azon epizódok hosszának összegét, melyek címében szerepel a
     * {@code "Ewing"} sztring.
     *
     * @return azon epizódok hosszának összege, melyek címében szerepel a
     * {@code "Ewing"} sztring
     */
    @Override
    public int getTotalRuntimeOfEpisodesWhoseTitleContainsEwing() {
        return EpisodeManager.getEpisodes().stream()
                .filter(episode -> episode.title().contains("Ewing"))
                .mapToInt(Episode::runtime)
                .sum();
    }
}
