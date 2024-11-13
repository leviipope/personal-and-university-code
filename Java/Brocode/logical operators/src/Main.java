import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       /*

       %% = AND
       || = OR
       !  = NOT

        */

        Scanner sc = new Scanner(System.in);
        System.out.println("You are playing a game, press q or Q to quit");
        String response = sc.nextLine();

        if(response.equals("q") || response.equals("Q")){
             System.out.println("You quit the game");
        }
        else{
            System.out.println("You are playing the game *pew pew*");
        }

    }
}