package feladat5_2;

public class Hallgato {
    private String neptuneKod;
    private String nev;
    private Szak szak;

    public Hallgato(String neptuneKod, String nev, Szak szak) {
        this.neptuneKod = neptuneKod;
        this.nev = nev;
        this.szak = szak;
    }

    public String getNeptuneKod() {
        return neptuneKod;
    }

    public String getNev() {
        return nev;
    }

    public Szak getSzak() {
        return szak;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hallgato{");
        sb.append("neptuneKod='").append(neptuneKod).append('\'');
        sb.append(", nev='").append(nev).append('\'');
        sb.append(", szak=").append(szak);
        sb.append('}');
        return sb.toString();
    }
}
