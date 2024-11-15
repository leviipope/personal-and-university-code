import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) throws WrongBirthDateException, SizeException{
        ArrayList<Person> personList = new ArrayList<>();
        try(Scanner sc = new Scanner(new File("person.txt"))){
            while (sc.hasNextLine()){
                String l = sc.nextLine();
                String[] lElements = l.split("[;,\\[\\]= ]");
                ArrayList<String> lElementsList = new ArrayList<>();
                for(String elem: lElements){
                    lElementsList.add(elem);
                }
                while (lElementsList.remove(""));

                for (String elem: lElementsList){
                    if(elem == ""){
                        System.out.println("ures");
                    }
                    else{
                        System.out.println(elem);
                    }
                }

                if(lElementsList.get(0).equals("Person")){
                    if(lElementsList.get(6).equals("null")){
                        personList.add(new Person(lElementsList.get(2),
                                LocalDate.parse(lElementsList.get(4))));
                    } else {
                        personList.add(new Person(lElementsList.get(2),
                                LocalDate.parse(lElementsList.get(4)),
                                lElementsList.get(6)));
                    }
                }

                if(lElementsList.get(0).equals("Employee")){
                    if(lElementsList.get(12).equals("null")){
                        personList.add(new Employee(Integer.parseInt(lElementsList.get(2)),
                                lElementsList.get(8),
                                LocalDate.parse(lElementsList.get(10))));
                    } else {
                        personList.add(new Employee(Integer.parseInt(lElementsList.get(2)),
                                lElementsList.get(8),
                                LocalDate.parse(lElementsList.get(10)),
                                lElementsList.get(12)));
                    }

                    if(lElementsList.get(0).equals("EmployeeWithSizes")){
                        if(lElementsList.get(18).equals("null")){
                            EmployeeWithSizes ew = new EmployeeWithSizes(
                                    Integer.parseInt(lElementsList.get(8)),
                                    lElementsList.get(14),
                                    LocalDate.parse(lElementsList.get(16)));
                            ew.setShoeSize(Integer.parseInt(lElementsList.get(2)));
                            ew.setHeightInCm(Integer.parseInt(lElementsList.get(4)));
                            personList.add(ew);
                        } else{
                            EmployeeWithSizes ew = new EmployeeWithSizes(
                                    Integer.parseInt(lElementsList.get(8)),
                                    lElementsList.get(14),
                                    LocalDate.parse(lElementsList.get(16)),
                                    lElementsList.get(18));
                            ew.setShoeSize(Integer.parseInt(lElementsList.get(2)));
                            ew.setHeightInCm(Integer.parseInt(lElementsList.get(4)));
                            personList.add(ew);
                        }
                    }
                }

            }
        } catch (FileNotFoundException e){
            System.out.println("nincs ilyen fájl");
        }

        for(Person person: personList){
            System.out.println(person);
        }
    }
}
