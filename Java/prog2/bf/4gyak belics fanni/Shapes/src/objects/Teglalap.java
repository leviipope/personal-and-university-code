package objects;

public class Teglalap extends Sokszog{
    double hosszabbOldal;
    double rovidebbOldal;

    public Teglalap(double hosszabbOldal, double rovidebbOldal){
        super(4);
        this.hosszabbOldal = hosszabbOldal;
        this.rovidebbOldal = rovidebbOldal;
    }


    @Override
    public double kerulet() {
        return 2*hosszabbOldal + 2*rovidebbOldal;
    }

    @Override
    public double terulet() {
        return hosszabbOldal*rovidebbOldal;
    }

    public double getHosszabbOldal() {
        return hosszabbOldal;
    }

    public double getRovidebbOldal() {
        return rovidebbOldal;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Teglalap{");
        sb.append("hosszabbOldal=").append(hosszabbOldal);
        sb.append(", rovidebbOldal=").append(rovidebbOldal);
        sb.append(", szogekSzama=").append(szogekSzama);
        sb.append('}');
        return sb.toString();
    }
}
