package feladat5_2;

public class Szak {
    private String nev;
    private String kod;
    private int felekSzama;

    public Szak(String nev, String kod, int felekSzama) {
        this.nev = nev;
        this.kod = kod;
        this.felekSzama = felekSzama;
    }

    public String getNev() {
        return nev;
    }
    public String getKod() {
        return kod;
    }
    public int getFelekSzama() {
        return felekSzama;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hallgato{");
        sb.append("nev='").append(nev).append('\'');
        sb.append(", kod='").append(kod).append('\'');
        sb.append(", felekSzama=").append(felekSzama);
        sb.append('}');
        return sb.toString();
    }
}
