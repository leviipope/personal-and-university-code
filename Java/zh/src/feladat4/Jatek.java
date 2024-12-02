package feladat4;

// Egyedi kivétel osztály
class AmobaException extends Exception {
    public AmobaException(String message) {
        super(message);
    }
}

public class Jatek {
    private String[][] mezo;
    private String kovetkezoJatekos;
    private boolean jatekInditva;

    // Konstruktor
    public Jatek() {
        mezo = new String[3][3];
        kovetkezoJatekos = "X";
        jatekInditva = false;
    }

    // A játék indítása
    public String jatekEloallit() {
        jatekInditva = true;
        kovetkezoJatekos = "X";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mezo[i][j] = null; // Töröljük az előző játékot
            }
        }
        return "A játék elindult. Az 'X' játékos kezd.";
    }

    // A játékos lépése
    public String jatekosLep(String jatekos, int sor, int oszlop) throws AmobaException {
        // 1. Ellenőrizzük, hogy elindították-e a játékot
        if (!jatekInditva) {
            throw new AmobaException("A játék még nem indult el.");
        }

        // 2. Megfelelő játékos ellenőrzése
        if (!jatekos.equals(kovetkezoJatekos)) {
            throw new AmobaException("Rossz játékos! A következő játékos: " + kovetkezoJatekos);
        }

        // 3. Érvényes mező ellenőrzése
        if (sor < 0 || sor > 2 || oszlop < 0 || oszlop > 2) {
            throw new AmobaException("Érvénytelen mező! Az érvényes indexek 0, 1, 2.");
        }

        // 4. Ha a mezőn már van jel
        if (mezo[sor][oszlop] != null) {
            throw new AmobaException("Ez a mező már foglalt!");
        }

        // 5. Jel elhelyezése
        mezo[sor][oszlop] = jatekos;

        // 6. Ellenőrizzük, hogy a játékos nyert-e
        if (checkVictory(jatekos)) {
            jatekInditva = false;  // Leállítjuk a játékot, mert nyert
            return jatekos + " nyert!";
        }

        // 7. Játékos váltás
        if (jatekos.equals("X")) {
            kovetkezoJatekos = "O";
        } else {
            kovetkezoJatekos = "X";
        }

        return "A játék folytatódik. Következő játékos: " + kovetkezoJatekos;
    }

    // Nyertes ellenőrzése (sorok, oszlopok, átlók)
    private boolean checkVictory(String jatekos) {
        // Sorok ellenőrzése
        for (int i = 0; i < 3; i++) {
            if (mezo[i][0] != null && mezo[i][0].equals(jatekos) &&
                mezo[i][1] != null && mezo[i][1].equals(jatekos) &&
                mezo[i][2] != null && mezo[i][2].equals(jatekos))
                {return true;}
        }

        // Oszlopok ellenőrzése
        for (int j = 0; j < 3; j++) {
            if (mezo[0][j] != null && mezo[0][j].equals(jatekos) &&
                mezo[1][j] != null && mezo[1][j].equals(jatekos) &&
                mezo[2][j] != null && mezo[2][j].equals(jatekos))
                {return true;}
        }

        return false;
    }

    public static void main(String[] args) {
        try {
            Jatek jatek = new Jatek();

            System.out.println(jatek.jatekEloallit());  // A játék elindul
            System.out.println(jatek.jatekosLep("X", 0, 0));  // X lép
            System.out.println(jatek.jatekosLep("O", 1, 1));  // O lép
            System.out.println(jatek.jatekosLep("X", 0, 1));  // X lép
            System.out.println(jatek.jatekosLep("O", 2, 2));  // O lép
            System.out.println(jatek.jatekosLep("X", 0, 2));  // X nyert

        } catch (AmobaException e) {
            System.out.println(e.getMessage());
        }
    }
}

