import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person implements Comparable<Employee>{
    private int id;
    private Department department;

    public Employee(int id, String name, LocalDate birtDate) throws WrongBirthDateException{
        super(name, birtDate);
        this.id = id;
    }

    public Employee(int id, String name, LocalDate birtDate, String nickName) throws WrongBirthDateException{
       this(id, name, birtDate);
       this.setNickName(nickName);
    }

    public int getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) throws DeptNotContainEmpException {
        if(department == null){
            this.department = null;
            return;
        }

        for(Employee emp: department.getEmployees()){
            if(emp.equals(this)){
                this.department = department;
            }
        }

        if(!this.department.equals(department)){
            throw new DeptNotContainEmpException("no employee in dept: " + department);
        }


    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [id=");
        builder.append(id);
        if (this.department == null) {
            builder.append(" Department [null]");
        } else {
            builder.append(" Department [id=");
            builder.append(this.department.getId());
            builder.append("; name=");
            builder.append(this.department.getName());
            builder.append("]");
        }
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}
