package feladat2_withchatgpt;

class Etel {
    private String nev;
    private String vonalkod;
    private int ar;
    private String lejaratDatuma;
    private String etelTipus;

    // Constructors
    public Etel() {}

    public Etel(String nev, String vonalkod, int ar, String lejaratDatuma, String etelTipus) {
        this.nev = nev;
        this.vonalkod = vonalkod;
        this.ar = ar;
        this.lejaratDatuma = lejaratDatuma;
        this.etelTipus = etelTipus;
    }

    // Getters and Setters
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getVonalkod() {
        return vonalkod;
    }

    public void setVonalkod(String vonalkod) {
        this.vonalkod = vonalkod;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String getLejaratDatuma() {
        return lejaratDatuma;
    }

    public void setLejaratDatuma(String lejaratDatuma) {
        this.lejaratDatuma = lejaratDatuma;
    }

    public String getEtelTipus() {
        return etelTipus;
    }

    public void setEtelTipus(String etelTipus) {
        this.etelTipus = etelTipus;
    }

    @Override
    public String toString() {
        return "Etel{" +
                "nev='" + nev + '\'' +
                ", vonalkod='" + vonalkod + '\'' +
                ", ar=" + ar +
                ", lejaratDatuma='" + lejaratDatuma + '\'' +
                ", etelTipus='" + etelTipus + '\'' +
                '}';
    }
}