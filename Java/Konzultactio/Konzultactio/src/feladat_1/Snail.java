package feladat_1;

public abstract class Snail implements Move{

    boolean eheto;
    String nemeheto;

    public Snail(boolean eheto){
        this.eheto=eheto;
    }
    //Ha egy konstruktor egymásik konstruktor akar meghívni
    public Snail(boolean eheto,String nemeheto){
        this(eheto);
        this.nemeheto=nemeheto;
    }

    @Override
    public double getSpeedInMeterPerSecond() {
        return 0;
    }
    //absztrakt metódus létrehozása
    abstract boolean move();

    //A mainben meg kell csinálni egypéldányt mindenhez majd aztán ki kell őket írni (Mindegyikhez kell kel toString())
    //Ez az UML ábrás feladat

}
