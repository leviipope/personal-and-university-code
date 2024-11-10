package objects;

public abstract class Sokszog {
    int szogekSzama;

    public Sokszog(int szogekSzama){
        this.szogekSzama = szogekSzama;
    }

    public int getSzogekSzama() {
        return szogekSzama;
    }

    public abstract double kerulet();
    public abstract double terulet();


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Sokszog{");
        sb.append("szogekSzama=").append(szogekSzama);
        sb.append('}');
        return sb.toString();
    }
}
