import objects.EgyenloOldaluHaromszog;
import objects.Negyzet;
import objects.Sokszog;
import objects.Teglalap;

public class Main {
    public static void main(String[] args) {
        /*
        Sokszog sokszog = new Sokszog() {
            @Override
            public double kerulet() {
                return 0;
            }

            @Override
            public double terulet() {
                return 0;
            }
        }*/

        Teglalap t1 = new Teglalap(4, 2);
        System.out.println(t1);

        Negyzet n1 = new Negyzet(13);
        System.out.println(n1);

        EgyenloOldaluHaromszog h1 = new EgyenloOldaluHaromszog(12);
        System.out.println(h1);
    }
}