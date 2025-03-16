package Model;

import java.io.Serializable;
import java.util.TreeSet;

public class Company implements Serializable {
    String name;
    String nameOfLeader;
    TreeSet<Department> departments;

    public Company(String name, String nameOfLeader) {
        this.name = name;
        this.nameOfLeader = nameOfLeader;
        departments = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfLeader() {
        return nameOfLeader;
    }

    public void setNameOfLeader(String nameOfLeader) {
        this.nameOfLeader = nameOfLeader;
    }

    public void addDepartment(Department department){
        departments.add(department);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Company{");
        sb.append("departments=").append(departments);
        sb.append(", nameOfLeader='").append(nameOfLeader).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
