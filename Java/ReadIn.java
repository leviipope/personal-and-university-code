import java.io.Console;

class Readln {
	public static void main(String[] args){
		Console console = System.console();
        while(true) {
		System.out.print("Kérek egy sztringet: ");
		String s = console.readLine();
        if (s.equals("vege")) break;
		System.out.println("Szöveg: " + s);
        }
	}
}