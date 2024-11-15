import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company("deik", "HA"));
        companies.add(new Company("BTK", "JS"));
        companies.add(new Company("TTK", "PA"));
        companies.add(new Company("NI IT", "SC"));
        companies.add(new Company("EPAM IT", "IGYB"));

        try(Formatter formatter = new Formatter(new File("company.txt"))){
            for(Company company: companies){
                formatter.format("%s; %s, valami\n", company.getName(), company.getNameOfLeader());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try(Formatter formatter = new Formatter(new File("company2.txt"))){
            for(Company company: companies){
                formatter.format("%s\n", company);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Person> personArrayList = new ArrayList<>();
        try {
            personArrayList.add(new Person("Anna", LocalDate.of(2004, 1,1)));
            personArrayList.add(new Person("Bela", LocalDate.of(2003, 2,1), "Beluska"));
            personArrayList.add(new Employee(30, "Cili", LocalDate.of(2002,3,3), "Cilike"));
            personArrayList.add(new Employee(40, "Denes", LocalDate.of(2001,3,3), "Cilike"));
            personArrayList.add(new Employee(50, "Elemer", LocalDate.of(2000,3,3), "Cilike"));
            EmployeeWithSizes ew = new EmployeeWithSizes(60, "Ferenc", LocalDate.of(1999, 6,6));
            ew.setShoeSize(40);
            ew.setHeightInCm(180);
            personArrayList.add(ew);
        } catch (WrongBirthDateException | HeightException | ShoeSizeException e) {
            throw new RuntimeException(e);
        }

        try(Formatter formatter = new Formatter(new File("person.txt"))){
            for(Person person: personArrayList){
                formatter.format("%s\n", person);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
