package feladat4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JatekTest {
    private Jatek jatek;

    @BeforeEach
    public void setUp() {
        jatek = new Jatek(); // Initialize the game before each test
    }

    // Test a winning scenario
    @Test
    public void testWinningGame() throws AmobaException {
        jatek.jatekEloallit(); // Start the game
        assertEquals("A játék folytatódik. Következő játékos: O", jatek.jatekosLep("X", 0, 0));
        assertEquals("A játék folytatódik. Következő játékos: X", jatek.jatekosLep("O", 1, 0));
        assertEquals("A játék folytatódik. Következő játékos: O", jatek.jatekosLep("X", 0, 1));
        assertEquals("A játék folytatódik. Következő játékos: X", jatek.jatekosLep("O", 1, 1));
        assertEquals("X nyert!", jatek.jatekosLep("X", 0, 2)); // Winning move

    }

    // Test the exception when no game is started
    @Test
    public void testGameNotStartedException() {
        AmobaException exception = assertThrows(AmobaException.class, () -> {
            jatek.jatekosLep("X", 0, 0); // Try to make a move without starting the game
        });
        assertEquals("A játék még nem indult el.", exception.getMessage());
    }

    // Test the exception for attempting to place a marker on an occupied cell
    @Test
    public void testOccupiedCellException() throws AmobaException {
        jatek.jatekEloallit(); // Start the game
        jatek.jatekosLep("X", 0, 0); // X plays at (0, 0)

        AmobaException exception = assertThrows(AmobaException.class, () -> {
            jatek.jatekosLep("O", 0, 0); // O tries to play on the same cell
        });
        assertEquals("Ez a mező már foglalt!", exception.getMessage());
    }


}

