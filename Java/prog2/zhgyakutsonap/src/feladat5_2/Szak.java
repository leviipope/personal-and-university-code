package feladat5_2;

public class Szak {
    private String nev;
    private String kod;
    private int felevekSzama;

    public Szak(String nev, String kod, int felevekSzama) {
        this.nev = nev;
        this.kod = kod;
        this.felevekSzama = felevekSzama;
    }

    public String getNev() {
        return nev;
    }

    public String getKod() {
        return kod;
    }

    public int getFelevekSzama() {
        return felevekSzama;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Szak{");
        sb.append("nev='").append(nev).append('\'');
        sb.append(", kod='").append(kod).append('\'');
        sb.append(", felevekSzama=").append(felevekSzama);
        sb.append('}');
        return sb.toString();
    }
}
