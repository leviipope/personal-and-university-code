public class Main {
    public static void main(String[] args) {

        int age = 99;

        if (age == 75) {
            System.out.println("You are old");
        }
        else if (age < 75 && age > 10) {
            System.out.println("You are young");
        }
        else if (age < 10) {
            System.out.println("You are very young");
        }
        else {
            System.out.println("You are probably dead");
        }
    }
}