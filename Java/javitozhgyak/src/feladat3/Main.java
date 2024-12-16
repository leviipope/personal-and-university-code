package feladat3;

public class Main {
    public static void main(String[] args) {
        Muskatli energikusmuskatli = new Muskatli(12,true);
        Muskatli simaMuskatli = new Muskatli(20,85,false);
        energikusmuskatli.novekszik();
        energikusmuskatli.fotoszintetizal();
        simaMuskatli.fotoszintetizal();

        Hovirag hovirag = new Hovirag(12,20,3);
        hovirag.novekszik();
        hovirag.fotoszintetizal();

        Fa fa = new Fa("dinnye",false,10,true);
        fa.novekszik();

        System.out.println(fa.getMagassag());
        System.out.println(Virag.getLetrehozottViragokSzama());

        System.out.println(energikusmuskatli.getEnergia());
        System.out.println(simaMuskatli.getEnergia());

        System.out.println(hovirag.getSziromMeret()+ " " + hovirag.getViztartalom() + " " + hovirag.getEnergia());

    }
}