package feladat5;

public class Auto {
    private String rendszam;
    private String marka;
    private String tipus;
    private String gyartasiEv;

    public Auto(String rendszam, String marka, String tipus, String gyartasiEv) {
        this.rendszam = rendszam;
        this.marka = marka;
        this.tipus = tipus;
        this.gyartasiEv = gyartasiEv;
    }

    public String getRendszam() {
        return rendszam;
    }
    public String getMarka() {
        return marka;
    }
    public String getTipus() {
        return tipus;
    }
    public String getGyartasiEv() {
        return gyartasiEv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auto{");
        sb.append("rendszam='").append(rendszam).append('\'');
        sb.append(", marka='").append(marka).append('\'');
        sb.append(", tipus='").append(tipus).append('\'');
        sb.append(", gyartasiEv='").append(gyartasiEv).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
