package feladat3;

public class Muskatli extends Virag implements Noveny {
    private boolean futoTipus;
    private int terjedesMerteke;

    // Első konstruktor: viztartalom, energia és futoTipus megadása
    public Muskatli(double viztartalom, double energia, boolean futoTipus) {
        super(viztartalom, energia);
        this.futoTipus = futoTipus;
        this.terjedesMerteke = 1; // Alapérték: 1
    }

    // Második konstruktor: viztartalom és futoTipus megadása, energia 100-ra állítva
    public Muskatli(double viztartalom, boolean futoTipus) {
        this(viztartalom, 100, futoTipus); // Első konstruktor hívása, energia = 100
    }

    @Override
    public void novekszik() {
        if (futoTipus) {
            terjedesMerteke += 2;
        } else {
            terjedesMerteke += 1;
        }
    }

    @Override
    public boolean fotoszintetizal() {
        viztartalom -= 1;
        energia += 1;
        return true;
    }

    public boolean isFutoTipus() {
        return futoTipus;
    }

    public int getTerjedesMerteke() {
        return terjedesMerteke;
    }
}

