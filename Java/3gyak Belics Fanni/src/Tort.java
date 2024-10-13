import java.util.Objects;

public class Tort {
    private int szamlalo;
    private int nevezo;

    static int counter;

    public Tort(){
        this.szamlalo = 0;
        this.nevezo = 1;

        counter++;
    }


    public Tort(int nevezo, int szamlalo) {
        this.nevezo = nevezo;
        this.szamlalo = szamlalo;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public int getSzamlalo(){
        return this.szamlalo;
    }

    public int getNevezo() {
        return nevezo;
    }

    public void setSzamlalo(int szamlalo){
        this.szamlalo = szamlalo;
    }

    public void setNevezo(int nevezo) {
        if(nevezo == 0){
            System.out.println("0 nem lehet nevező!");
            this.nevezo = 1;
        }
        else {
            this.nevezo = nevezo;
        }

        System.out.println("Nevező új értéke: " + this.nevezo);


    }

    /*@Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Tort{");
        sb.append("szamlalo=").append(szamlalo);
        sb.append(", nevezo=").append(nevezo);
        sb.append('}');
        return sb.toString();
    }*/
    @Override
    public String toString(){
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(szamlalo);
        stringBuffer.append("/");
        stringBuffer.append(nevezo);

        return stringBuffer.toString();
    }

    public double ertek(){
        return (double) szamlalo /nevezo;
    }

    public int lnko(int a,int b){
        while(a != b){
            if(a > b){
                a -= b;
            }
            else{
                b -= a;
            }
        }

        return a;
    }

    public Tort egyszerusit(){
        int oszto = lnko(szamlalo, nevezo);
        this.szamlalo /= oszto;
        this.nevezo /= oszto;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tort tort = (Tort) o;
        return szamlalo == tort.szamlalo && nevezo == tort.nevezo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(szamlalo, nevezo);
    }

    public Tort szorzasEgesszel(int szorzo){
        this.szamlalo *= szorzo;

        return this.egyszerusit();
    }

    public Tort osszead(Tort tort){
        int ujSzamlalo = this.szamlalo * tort.nevezo +
                        tort.szamlalo * this.nevezo;
        int ujNevezo = tort.nevezo + this.nevezo;

        Tort ujTort = new Tort(ujNevezo, ujSzamlalo);

        return ujTort.egyszerusit();

    }
}
