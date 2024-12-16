package feladat3;

public class Hovirag extends Virag implements Noveny {
    private int sziromMeret;

    // Konstruktor: viztartalom, energia, sziromMeret megadása
    public Hovirag(double viztartalom, double energia, int sziromMeret) {
        super(viztartalom, energia);
        this.sziromMeret = sziromMeret;
    }

    @Override
    public void novekszik() {
        sziromMeret += 1;
    }

    @Override
    public boolean fotoszintetizal() {
        viztartalom -= 3;
        energia += 3;
        return true;
    }

    public int getSziromMeret() {
        return sziromMeret;
    }
}
