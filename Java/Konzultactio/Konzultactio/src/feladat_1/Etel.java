package feladat_1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public class Etel implements Comparable<Etel>{
    @JsonProperty("nev")
    private String nev;
    @JsonProperty("vonalkod")
    private String vonalkod;
    @JsonProperty("ar")
    private double ar;
    @JsonProperty("lejaratDatuma")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy.MM.dd")
    private LocalDate lejaratDatuma;
    @JsonProperty("etelTipus")
    private String etelTipusa;



    private static final int MINAR=100; // Konstans

    public Etel(){

    }

    /**
     * Az étel osztályhoz hoz létre egy példány
     * @param nev az étel neve
     * @param vonalkod az étel vonalkódja
     * @param ar az étel ára
     * @param lejaratDatuma az étel lejárati dátuma
     * @param etelTipusa az étel tipusa
     */
    public Etel(String nev, String vonalkod, double ar, LocalDate lejaratDatuma, String etelTipusa) throws EtelException {

        this.nev = nev;
        this.vonalkod = vonalkod;
        if (ar<0){
            throw new EtelException("Az ár nem lehet 0nál kisebb");
        }
        this.ar = ar;
        this.lejaratDatuma = lejaratDatuma;
        this.etelTipusa = etelTipusa;
    }

    /**
     * Visszadja az étel nevét
     * @return az étel nevét
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

    public String getEtelTipusa() {
        return etelTipusa;
    }


    /**
     * Összehasonlítja két étel objektumot
     * @param o az étel amivel hasonlítunk
     * @return igaz, ha vonalkód és az ételtípus megegyezik egyébként hamisat
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etel etel)) return false;
        return Objects.equals(vonalkod, etel.vonalkod) && Objects.equals(etelTipusa, etel.etelTipusa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(/*vonalkod,*/ etelTipusa);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Etel{");
        sb.append("nev='").append(nev).append('\'');
        sb.append(", vonalkod='").append(vonalkod).append('\'');
        sb.append(", ar=").append(ar);
        sb.append(", lejaratDatuma=").append(lejaratDatuma);
        sb.append(", etelTipusa='").append(etelTipusa).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Etel o) {
        int v = o.etelTipusa.compareTo(this.etelTipusa); // azért lesz ez csökkenő, mert fordítva írtuk be az értékeket
        if (v!=0){
            return v;
        }
        return o.nev.compareTo(this.nev);
    }

    //Előfordulhat, hogy kel egy compareable
    //Előfordulhat hogy kell egy statikus érték (konstans)
}
