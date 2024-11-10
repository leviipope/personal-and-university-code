package objects;

public class Negyzet extends Teglalap{

    public Negyzet(double oldalhossz) {
        super(oldalhossz, oldalhossz);
    }

    public double getOldalhossz(){
        return hosszabbOldal;
    }
}
