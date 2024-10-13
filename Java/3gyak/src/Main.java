public class Main {
    public static void main(String[] args) {
        KTort k1 = new KTort(10, 2);
        System.out.println(k1.getSzamlalo());
        System.out.println(k1.getNevezo());
        System.out.println(k1.ertek());
        System.out.println(KTort.tortOsztalyObjDb());
        System.out.println("k1: " + k1);

        KTort k2 = new KTort();
        System.out.println(KTort.tortOsztalyObjDb());
        System.out.println("k2: " + k2);
        KTort k3 = new KTort(5);
        System.out.println(KTort.tortOsztalyObjDb());
        System.out.println("k3: " + k3);

        KTort k4 = new KTort(15, -12);
        System.out.println("k4: " + k4);

        KTort k5 = new KTort(-125, 30);
        System.out.println("k5: " + k5);

        System.out.println(k1.equals(null));
        System.out.println(k1.equals(k2));
        System.out.println(k1.equals(k3));

        k1.egeszSzoroz(5);
        System.out.println("k1: " + k1);

        k1.szoroz(k2);
        System.out.println("k1: " + k1);

        k1.egeszOsztas(3);
        System.out.println("k1: " + k1);
        k1.oszt(k3);
        System.out.println("k1: " + k1);

        k1.reciprok();
        System.out.println("k1: " + k1);

        k1.hozzaad(k3);
        System.out.println("k1: " + k1);
        k1.egeszetHozzaad(10);
        System.out.println("k1: " + k1);

        k1.kivon(k3);
        System.out.println("k1: " + k1);

    }
}