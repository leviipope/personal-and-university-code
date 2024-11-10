package objects;

public class EgyenloOldaluHaromszog extends Sokszog{
    double oldalhossz;

    public EgyenloOldaluHaromszog(double oldalhossz){
        super(3);
        this.oldalhossz = oldalhossz;
    }

    @Override
    public double kerulet() {
        return 3*oldalhossz;
    }

    @Override
    public double terulet() {
        return (oldalhossz*oldalhossz)/2;
    }

    public double getOldalhossz() {
        return oldalhossz;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EgyenloOldaluHaromszog{");
        sb.append("oldalhossz=").append(oldalhossz);
        sb.append(", szogekSzama=").append(szogekSzama);
        sb.append('}');
        return sb.toString();
    }
}
