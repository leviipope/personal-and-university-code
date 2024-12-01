package feladat_1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Adatok {
    @JsonProperty("adatok")
    private List<Etel> adatok;

    public List<Etel> getAdatok() {
        return adatok;
    }

    public void setAdatok(List<Etel> adatok) {
        this.adatok = adatok;
    }
}
