package feladat1_3;

import java.util.Objects;

public class Orvos {
    private String nev;
    private String szakirany;
    private int praxisEve;
    private String rendeloCime;
    private int betegekSzama;

    /**
     * Létrehoz egy orvos példányt
     * @param nev
     * @param szakirany
     * @param praxisEve
     * @param rendeloCime
     * @param betegekSzama
     */
    public Orvos(String nev, String szakirany, int praxisEve, String rendeloCime, int betegekSzama) {
        this.nev = nev;
        this.szakirany = szakirany;
        this.praxisEve = praxisEve;
        this.rendeloCime = rendeloCime;
        this.betegekSzama = betegekSzama;
    }

    /**
     * Visszatér a példány betegeinek számával
     * @return a betegek száma
     */
    public int getBetegekSzama() {
        return betegekSzama;
    }
    public String getRendeloCime() {
        return rendeloCime;
    }
    public int getPraxisEve() {
        return praxisEve;
    }
    public String getSzakirany() {
        return szakirany;
    }
    public String getNev() {
        return nev;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Orvos{");
        sb.append("nev='").append(nev).append('\'');
        sb.append(", szakirany='").append(szakirany).append('\'');
        sb.append(", praxisEve=").append(praxisEve);
        sb.append(", rendeloCime='").append(rendeloCime).append('\'');
        sb.append(", betegekSzama=").append(betegekSzama);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Viszgálja hogy ez az objekt egyenlő e a többivel
     * @param o az objekt amit vizsgál
     * @return igaz ha egyenlőek, hamis ha nem
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orvos orvos)) return false;
        return Objects.equals(nev, orvos.nev) && Objects.equals(rendeloCime, orvos.rendeloCime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, rendeloCime);
    }
}
