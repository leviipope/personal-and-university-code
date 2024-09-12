import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console c = System.console();
        System.out.println("Kérek egy stringet: ");
        String s = c.readLine();
        System.out.println("Ez volt: " + s);
    }
}