import java.io.Console;

public class ReadIn {
    public static void main(String[] args) {
        Console c = System.console();
        System.out.println("Kérek egy sztringet: ");
        String v = c.readLine();
        System.out.println("Ez volt: " + v);
    }
}