import java.util.Scanner;


public class Test {

    static int lnko(int a, int b)
    {
        int r;

        do{
            r = a % b;
            a = b;
            b = r;


        }while(r!=0);

        return a;
    }

    public static boolean palindrom(int szam)
    {
        int eltesz = szam;
        int szj;
        int forditott=0;

        while(szam!=0)
        {
            szj = szam % 10;
            szam = szam/10;
            forditott = forditott*10 + szj;

        }
        return eltesz == forditott;
    }

    public static boolean relativprim(int [] t)
    {
        for(int i = 0;i<t.length-1;i++)
        {
            for(int j = i+1; j<t.length;j++)
            {
                if(lnko(t[i],t[j])!=1)
                {
                    return false;
                }
            }

        }

        return true;
    }
    public static void main(String[] args) {



        //System.out.println("lnko="+lnko(360,225));

        //System.out.println("palindrom = "+palindrom(1331));
        int [] Szamtomb = new int[4];

        Scanner sc = new Scanner(System.in); // <--- standard input olvasasa

        for(int i = 0; i<Szamtomb.length;i++)
        {
            System.out.print("Szamtomb["+i+"] = ");
            Szamtomb[i] = sc.nextInt();
        }

        System.out.println("paronkent prim?: " + relativprim(Szamtomb));
    }

}

