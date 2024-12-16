package feladat3;

public abstract class Virag {
    protected static int letrehozottViragokSzama = 0;
    protected double viztartalom;
    protected double energia;

    public Virag(double viztartalom, double energia) {
        this.viztartalom = viztartalom;
        this.energia = energia;
        letrehozottViragokSzama++;
    }

    public static int getLetrehozottViragokSzama() {
        return letrehozottViragokSzama;
    }

    public double getViztartalom() {
        return viztartalom;
    }

    public double getEnergia() {
        return energia;
    }

    public abstract boolean fotoszintetizal();
}
