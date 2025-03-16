package Model;

import Exceptions.DeptNotContainEmpException;

import java.util.HashSet;

public class Department implements Comparable<Department>{
    String id;
    String name;
    HashSet<Employee> employees;

    public Department(String id, String name){
        this.id = id;
        this.name = name;
        employees = new HashSet<>();
    }

    public void addEmployee(Employee emp) throws DeptNotContainEmpException {
        employees.add(emp);
        emp.setDepartment(this);
    }

    public void removeEmployee(Employee employee) throws DeptNotContainEmpException {
        employees.remove(employee);
        employee.setDepartment(null);
    }

    public void clearEmployees(){
        employees = new HashSet<>();
    }

    public HashSet<Employee> getEmployees(){
        return employees;
    }

    @Override
    public int compareTo(Department o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[id=");
        builder.append(id);
        builder.append("; name=");
        builder.append(name);
        builder.append("]");

        return builder.toString();
    }
}
