package feladat2_3;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rendeles {
    @JsonProperty("megrendelo")
    private String megrendelo;
    @JsonProperty("osszeg")
    private int osszeg;
    @JsonProperty("cim")
    private String cim;

    public Rendeles(String megrendelo, int osszeg, String cim) {
        this.megrendelo = megrendelo;
        this.osszeg = osszeg;
        this.cim = cim;
    }

    public Rendeles() {

    }

    public String getMegrendelo() {
        return megrendelo;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public String getCim() {
        return cim;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rendeles{");
        sb.append("megrendelo='").append(megrendelo).append('\'');
        sb.append(", osszeg=").append(osszeg);
        sb.append(", cim='").append(cim).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
