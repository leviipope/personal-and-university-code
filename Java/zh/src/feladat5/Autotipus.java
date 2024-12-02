package feladat5;

public class Autotipus {
    private String marka;
    private String tipus;

    public Autotipus(String marka, String tipus) {
        this.marka = marka;
        this.tipus = tipus;
    }

    public String getMarka() {
        return marka;
    }
    public String getTipus() {
        return tipus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Autotipus{");
        sb.append("marka='").append(marka).append('\'');
        sb.append(", tipus='").append(tipus).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
