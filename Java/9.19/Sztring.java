import java.util.Scanner;

public class Sztring {
    public static void main(java.lang.String[] args) {
        String[] stringTomb = new String[5];

        Scanner reader = new Scanner(System.in);

        for(int i = 0; i<stringTomb.length; i++){
            System.out.println("Kérek egy sztringet: ");
            String s = reader.nextLine();
            stringTomb[i] = s;

            //stringTomb[i] = reader.nextLine();
        }

        for(String d: stringTomb){
            System.out.print(d + "; " );
            System.out.print(d.length() + "; ");
            System.out.print(d.toLowerCase() + "; ");
            System.out.print(d.toUpperCase() + "; ");
            System.out.print(d.isBlank() + "; ");
            System.out.println(d.contains(" "));
        }

        reader.close();
    }
}