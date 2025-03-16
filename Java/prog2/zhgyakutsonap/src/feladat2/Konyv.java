package feladat2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Konyv {
    //fasterxml.jackson
    //jackson.core
    //jackson.databind

    @JsonProperty("id")
    private int id;

    @JsonProperty("cim")
    private String cim;

    @JsonProperty("szerzo")
    private String szerzo;

    @JsonProperty("kiadasEve")
    private int kiadasEve;

    @JsonProperty("mufaj")
    private String mufaj;

    @JsonProperty("ISBN")
    private double ISBN;

    public int getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public int getKiadasEve() {
        return kiadasEve;
    }

    public String getMufaj() {
        return mufaj;
    }

    public double getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Konyv{");
        sb.append("id=").append(id);
        sb.append(", cim='").append(cim).append('\'');
        sb.append(", szerzo='").append(szerzo).append('\'');
        sb.append(", kiadasEve=").append(kiadasEve);
        sb.append(", mufaj='").append(mufaj).append('\'');
        sb.append(", isbn=").append(ISBN);
        sb.append('}');
        return sb.toString();
    }
}
