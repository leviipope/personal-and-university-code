import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        ArrayList<Company> companies = new ArrayList<>();
        File file = new File("company.txt");

        try(Scanner sc = new Scanner(file)){
            while (sc.hasNextLine()){
                String l = sc.nextLine();
                System.out.println(l);
                String[] sArray = l.split("; ");
                String[] sArray2 = sArray[1].split(", ");
                for(String s : sArray){
                    System.out.println(s);
                }
                for(String s : sArray2){
                    System.out.println(s);
                }
                companies.add(new Company(sArray[0], sArray2[0]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        for(Company company: companies){
            System.out.println(company);
        }
    }
}
