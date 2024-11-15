import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Company c1 = new Company("BMW", "Szabo Adam");
        Department d1 = new Department("it", "id dept");
        Department d2 = new Department("sales", "sales dept");
        Department d3 = new Department("network", "network dept");

        c1.addDepartment(d1);
        c1.addDepartment(d2);
        c1.addDepartment(d3);

        Employee e1 = null;
        try {
            e1 = new Employee(10, "Stepe Black", LocalDate.of(2000,12,30));
        } catch (WrongBirthDateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(e1);

        try {
            d1.addEmployee(e1);
        } catch (DeptNotContainEmpException e) {
            throw new RuntimeException(e);
        }

        EmployeeWithSizes ew1 = null;

        try {
            ew1 = new EmployeeWithSizes(10, "John", LocalDate.of(2001, 12,1), "Johnny");
            ew1.setShoeSize(50);
            ew1.setHeightInCm(10);
        } catch (CompanyException e) {
            System.out.println(e.getMessage());
        }

        EmployeeWithSizes ew2 = null;
        try {
            ew2 = new EmployeeWithSizes(20, "Bela", LocalDate.of(2000,1,1));
        } catch (WrongBirthDateException e) {
            System.out.println(e.getMessage());
        }

        try {
            ew2.setShoeSize(50);
            ew2.setHeightInCm(10);
        } catch (ShoeSizeException | HeightException e) {
            System.out.println(e.getMessage());
        }

        EmployeeWithSizes ew3 = null;
        try {
            ew3 = new EmployeeWithSizes(20, "Bela", LocalDate.of(2000,1,1));
        } catch (WrongBirthDateException e) {
            System.out.println(e.getMessage());
        }

        try {
            ew3.setShoeSize(50);
            ew3.setHeightInCm(10);
        } catch (SizeException e) {
            System.out.println(e.getMessage());
        }
    }
}