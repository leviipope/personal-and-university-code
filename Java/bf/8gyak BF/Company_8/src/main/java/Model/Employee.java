package Model;

import Exceptions.DeptNotContainEmpException;
import Exceptions.WrongBirthdatException;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person implements Comparable<Employee>{
    int id;
    Department department;

    public Employee(int id, Department department, String name, LocalDate birthDate) throws WrongBirthdatException {
        super(name, birthDate);
        this.id = id;
        this.department = department;
    }

    public void setDepartment(Department department) throws DeptNotContainEmpException{
        if(department == null){
            this.department = null;
        }
        if(department.getEmployees().contains(this)){
            this.department = department;
        } else {
            throw new DeptNotContainEmpException("Department doesn't contain employee");
        }

        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [id=");
        builder.append(id);

        if(department == null){
            builder.append("; Department [null]");
        }
        else {
            builder.append("; Department[");
            builder.append(department);
            builder.append("]");
        }

        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");

        return builder.toString();
    }
}
