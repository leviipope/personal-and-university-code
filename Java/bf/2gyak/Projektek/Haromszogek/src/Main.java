import java.util.Scanner;

public class Main {
    /*
    * Olvassunk be végjelig a bemenetről,
    * ;-vel elválasztott számokat
    * És nézzük meg, hogy készíthető-e belőle háromszög
    * És ha igen, milyen
    * Kezeljük a hibákat!
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

       String[] numbersAsString =  s.split(";");
       if(numbersAsString.length < 3){
           System.out.println("Nem adtunk meg elég számot");
           return;
       } else if(numbersAsString.length > 3){
           System.out.println("Csak az első 3 számot vesszük figyelembe");
       }

       Double[] numbers = new Double[3];
       for(int i = 0; i < 3; i++){
           numbers[i] = Double.parseDouble(numbersAsString[i]);
       }

       if(numbers[0] + numbers[1] > numbers[2] &&
               numbers[1] + numbers[2] > numbers[0] &&
               numbers[0] + numbers[2] > numbers[1]){
           System.out.println("Létezik a háromszög");
       } else
       {
           System.out.println("A háromszög nem létezik!");
       }
    }
}