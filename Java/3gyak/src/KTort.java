import java.util.Objects;

public class KTort {
    private int szamlalo;
    private int nevezo;

    private static int tortSzamlalo = 0;

    public KTort(int szamlalo, int nevezo){
        this.szamlalo = szamlalo;
        this.nevezo = nevezo;

        if ( this.nevezo == 0){
            this.nevezo = 1;
            this.szamlalo = 0;
        }

        tortSzamlalo++;
        egyszerusit();
    }

    public KTort(){
        this.nevezo = 1;
        this.szamlalo = 0;
        tortSzamlalo++;
    }

    public KTort(int egesz){
        this.nevezo = 1;
        this.szamlalo = egesz;
        tortSzamlalo++;
    }

    public int getSzamlalo(){
        return szamlalo;
    }

    public int getNevezo() {
        return nevezo;
    }

    public static int tortOsztalyObjDb() {
        return tortSzamlalo;
    }

    public double ertek(){
        return (double) szamlalo / nevezo;
    }

    private void egyszerusit(){
        int p_sz = Math.abs(szamlalo);
        int p_n = Math.abs(nevezo);
        int lnko;
        while (true){
            if(p_n == 0 || p_sz == 0){
                lnko = 1;
                break;
            }
            if(p_n == p_sz){
                lnko = p_n;
                break;
            }
            if(p_n > p_sz){
                p_n -= p_sz;
            }
            if(p_sz > p_n){
                p_sz -= p_n;
            }
        }
        if (nevezo < 0){
            szamlalo *= -1; //szamlalo = -szamlalo
            nevezo *= -1;
        }
        szamlalo /= lnko;
        nevezo /= lnko;
    }

    public void egeszSzoroz(int egesz){
        szamlalo *= egesz;
        egyszerusit();
    }

    public void szoroz(KTort t){
        szamlalo = this.szamlalo * t.szamlalo;
        nevezo = this.nevezo * t.nevezo;
        this.egyszerusit();
    }

    public void reciprok(){
        int cs = szamlalo;
        szamlalo = nevezo;
        nevezo = cs;

        if (nevezo < 0){
            szamlalo *= -1;
            nevezo *= -1;
        }
        if (nevezo == 0){
            szamlalo = 0;
            nevezo = 1;
        }
    }

    public void oszt(KTort t1){
        int ujSzamlalo = this.szamlalo * t1.nevezo;
        int ujNevezo = this.nevezo * t1.szamlalo;
        this.szamlalo = ujSzamlalo;
        this.nevezo = ujNevezo;
        this.egyszerusit();
    }

    public void egeszOsztas(int egesz){
        if(egesz == 0){
            szamlalo = 0;
            nevezo = 1;
        }
        nevezo *= egesz;
        this.egyszerusit();
    }

    public void hozzaad(KTort t1){
        int ujSzamlalo = this.szamlalo * t1.nevezo + t1.szamlalo * this.nevezo;
        int ujNevezo = this.nevezo * t1.szamlalo;
        this.szamlalo = ujSzamlalo;
        this.nevezo = ujNevezo;
        this.egyszerusit();
    }

    public void egeszetHozzaad(int egesz){
        int ujSzamlalo = this.szamlalo + this.nevezo * egesz;
        this.szamlalo = ujSzamlalo;
        this.egyszerusit();
    }

    public void kivon(KTort t1){
        /*int ujSzamlalo = this.szamlalo * t1.nevezo - t1.szamlalo * this.nevezo;
        int ujNevezo = this.nevezo * t1.szamlalo;
        this.szamlalo = ujSzamlalo;
        this.nevezo = ujNevezo;
        this.egyszerusit();*/

        KTort tk = new KTort(-t1.szamlalo, t1.nevezo);
        this.hozzaad(tk);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("KTort{");
        sb.append("szamlalo=").append(szamlalo);
        sb.append(", nevezo=").append(nevezo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KTort kTort = (KTort) o;
        return szamlalo == kTort.szamlalo && nevezo == kTort.nevezo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(szamlalo, nevezo);
    }
}
