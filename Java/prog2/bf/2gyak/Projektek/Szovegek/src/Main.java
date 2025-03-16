import java.util.Scanner;

public class Main {
    /*
    * Olvassunk be 10 db sort
    * milyen hosszú
    * van-e benne szóköz
    * nagy és kisbetűs
    * első szava
    * üres-e
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] texts = new String[3];

        for(int i=0; i<texts.length; i++){
            System.out.println("kérek egy szöveget: ");
            texts[i] = scanner.nextLine();

            System.out.println("Hossza: " + texts[i].length());
            //System.out.println("Szóköz helye: " + texts[i].indexOf(" "));
            if(texts[i].indexOf(' ') == -1){
                System.out.println("Nincs benne szóköz");
                System.out.println("Első szava: " + texts[i]);
            } else
            {
                System.out.println("Van benne szóköz");
                System.out.println("Első szava: " + texts[i].substring(0, texts[i].indexOf(" ")));
            }
            System.out.println("Nagybetűs: " + texts[i].toUpperCase());
            System.out.println("Kisbetűs: " + texts[i].toLowerCase());
            System.out.println("Üres-e?" + texts[i].isEmpty());

            System.out.println(texts[i].trim());
        }
    }
}



