import java.io.Console;

class ReadIn2 {
	public static void main(String[] args){
		Console console = System.console();
		
		while(true){
			System.out.println("Kérek egy szöveget");
			String s = console.readLine();
			if(s == null){
				break;
			}
			
			System.out.println("Szöveg :" + s);
		}
	}
}