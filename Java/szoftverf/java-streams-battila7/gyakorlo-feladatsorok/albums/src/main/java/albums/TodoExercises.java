package albums;

import albums.domain.Album;

import java.util.Map;
import java.util.Optional;

public class TodoExercises implements Exercises {
    /**
     * Kiírja az összes különböző zenei stílus (genre) nevét az ábécé
     * szerint növekvő sorrendben. Minden stílus új sorba kerüljön.
     */
    @Override
    public void printEveryDifferentGenreInAscendingOrder() {

    }

    /**
     * Visszaadja a legtöbb dalt tartalmazó albumot.
     */
    @Override
    public Optional<Album> getTheAlbumWithTheMostSongs() {
        return Optional.empty();
    }

    /**
     * Visszaad egy olyan Mapet, mely a "The Beatles" előadó által kiadott albumok
     * címéhez rendeli az albumon található dalok számát.
     */
    @Override
    public Map<String, Integer> getTheNumberOfSongsOnEachBeatlesAlbum() {
        return Map.of();
    }

    /**
     * Kiírja az előadók Instrgram felhasználónevét a következő formátumban:
     * <pre>
     *     <előadó neve>: <Instagram felhasználónév>
     *    * </pre>
     * <p>
     * Figyelem: Az előadók között lehetnek olyanok is, akiknek nincs Instagram
     * fiókja.
     */
    @Override
    public void printEachArtistsInstagramHandle() {

    }

    /**
     * Visszaad egy olyan Mapet, mely az albumok címeihez a rajtuk található dalok számát
     * rendeli.
     */
    @Override
    public Map<String, Long> getTheNumberOfSongsOnEachAlbum() {
        return Map.of();
    }
}
