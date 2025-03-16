package org.example;

import Exceptions.*;
import Model.Department;
import Model.Employee;
import Model.EmployeeWithSizes;
import Model.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person p1;

        try{
            p1 = new Person("Bence", LocalDate.of(2001, 8, 4));
        } catch (WrongBirthdatException e){
            System.out.println(e.getMessage());
        } catch (CompanyException e){
            System.out.println("Company exception");
        }

        System.out.println("-------");

        try{
            Department dep1 = new Department("sales1", "Sales");
            Employee emp1 = new Employee(1, dep1, "Bence", LocalDate.of(1928, 8, 4));
            dep1.addEmployee(emp1);
            dep1.clearEmployees();
            emp1.setDepartment(dep1);
        }
        catch (WrongBirthdatException e){
            System.out.println(e.getMessage());
        } catch (DeptNotContainEmpException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--------");

        try{
            Department dep1 = new Department("sales1", "Sales");
            Employee emp1 = new Employee(1, dep1, "Bence", LocalDate.of(2001, 8, 4));
            dep1.addEmployee(emp1);
            dep1.clearEmployees();
            emp1.setDepartment(dep1);
        }
        catch (CompanyException e) {
            System.out.println(e.getMessage());System.out.println(e.getMessage());
        }

        try{
            Department dep1 = new Department("sales1", "Sales");
            EmployeeWithSizes emp2 = new EmployeeWithSizes(2, dep1, "Bence", LocalDate.of(2001, 8, 4),
                    10, 65);
        } catch (HeightException e) {
            throw new RuntimeException(e);
        } catch (ShoeSizeException e) {
            throw new RuntimeException(e);
        } catch (WrongBirthdatException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Program vége");

    }
}