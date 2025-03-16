import java.io.Console;

class ReadIn {
	public static void main(String[] args){
		Console console = System.console();
		
		System.out.println("Kérek egy szöveget");
		String s = console.readLine();
		System.out.println("Szöveg :" + s);
	}
}