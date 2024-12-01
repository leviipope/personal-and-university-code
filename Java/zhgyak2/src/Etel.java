import java.time.LocalDate;
import java.util.Objects;

public class Etel implements Comparable<Etel>{
    private String nev;
    private String vonalkod;
    private double ar;
    private LocalDate lejaratDatuma;
    private String etelTipus;

    private static final int minAr = 100;

    /**
     *
     * @param nev
     * @param vonalkod
     * @param ar
     * @param lejaratDatuma
     * @param etelTipus
     */
    public Etel(String nev, String vonalkod, double ar, LocalDate lejaratDatuma, String etelTipus) {
        this.nev = nev;
        this.vonalkod = vonalkod;
        this.ar = ar;
        this.lejaratDatuma = lejaratDatuma;
        this.etelTipus = etelTipus;
    }

    /**
     *
     * @return
     */
    public String getNev() {
        return nev;
    }
    public String getVonalkod() {
        return vonalkod;
    }
    public double getAr() {
        return ar;
    }
    public LocalDate getLejaratDatuma() {
        return lejaratDatuma;
    }
    public String getEtelTipus() {
        return etelTipus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Etel{");
        sb.append("nev='").append(nev).append('\'');
        sb.append(", vonalkod='").append(vonalkod).append('\'');
        sb.append(", ar=").append(ar);
        sb.append(", lejaratDatuma=").append(lejaratDatuma);
        sb.append(", etelTipus='").append(etelTipus).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etel etel)) return false;
        return Objects.equals(vonalkod, etel.vonalkod) && Objects.equals(etelTipus, etel.etelTipus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vonalkod, etelTipus);
    }

    @Override
    public int compareTo(Etel o) {
        int v = o.etelTipus.compareTo(etelTipus);
        if (v != 0) {
            return v;
        }
        return o.nev.compareTo(this.nev);
    }
}






