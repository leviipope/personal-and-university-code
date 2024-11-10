public class Main {
    public static void main(String[] args) {
        Tort tortUres = new Tort();
        System.out.println("Törtek száma: " + Tort.getCounter());

        Tort tortAll = new Tort(4,3);
        System.out.println("Törtek száma: " + Tort.getCounter());

        System.out.println("Tortures " + tortUres);
        System.out.println("TortAll " + tortAll);

        tortUres.setSzamlalo(1);
        tortUres.setNevezo(0);

        System.out.println(tortUres.ertek());

        Tort egyszerusitsd = new Tort(27,81);
        System.out.println("LNKO: " + egyszerusitsd.lnko(27, 81));
        System.out.println("Egyszerű tört: " + egyszerusitsd.egyszerusit());

        System.out.println(tortAll + " =?"
                            + tortUres + " " +
                            tortAll.equals(tortUres));

        System.out.println(tortUres + "=?" + tortUres
                            + " " +
                            tortUres.equals(tortUres));

        System.out.println("Szorzas elott: " + tortAll);
        System.out.println(tortAll + " * 5 = " + tortAll.szorzasEgesszel(5) );
        tortAll = tortAll.szorzasEgesszel(5);

        System.out.println(tortAll + " + " + egyszerusitsd + " = " + tortAll.osszead(egyszerusitsd));
    }
}