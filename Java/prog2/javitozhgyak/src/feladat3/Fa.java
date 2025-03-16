package feladat3;

public class Fa implements Noveny {
    private String termes;
    private boolean orokzold;
    private double magassag;
    private boolean fotoszintetizal;
    private static final int NOVEKEDES_MERTEKE = 15;

    public Fa(String termes, boolean orokzold, double magassag, boolean fotoszintetizal) {
        this.termes = termes;
        this.orokzold = orokzold;
        this.magassag = magassag;
        this.fotoszintetizal = fotoszintetizal;
    }

    @Override
    public void novekszik() {
        if (orokzold) {
            magassag += NOVEKEDES_MERTEKE;
        } else {
            magassag += NOVEKEDES_MERTEKE * 0.75;
        }
    }

    public String getTermes() {
        return termes;
    }

    public boolean isOrokzold() {
        return orokzold;
    }

    public double getMagassag() {
        return magassag;
    }

    public boolean isFotoszintetizal(){
        return fotoszintetizal;
    }
}

