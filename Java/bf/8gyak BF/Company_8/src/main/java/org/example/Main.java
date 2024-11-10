package org.example;

import Exceptions.*;
import Model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongBirthdatException {
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company("weCan", "TB"));
        companies.add(new Company("NI", "KJB"));
        companies.add(new Company("TATA Consulting", "BG"));
        companies.add(new Company("CosmoConsult", "AZ"));
        companies.add(new Company("IdomSoft", "BA"));

        try(Formatter formatter = new Formatter(new File("companies.txt"))){
            for(Company company : companies){
                formatter.format("%s,%s\n", company.getName(), company.getNameOfLeader());
                //str.format("{}, {}", companyName, companyLeader)
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Nincs ilyen file");
        }

        System.out.println("**********");

        ArrayList<Company> companyList = new ArrayList<>();
        File file = new File("companies.txt");
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                System.out.println(line);

                String[] strings = line.split(",");

                /*
                for (String str : strings){
                    System.out.println(str);
                }*/

                companyList.add(new Company(strings[0], strings[1]));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nincs ilyen file");
        }

        for (Company company : companyList){
            System.out.println(company);
        }

        System.out.println("************");

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Dani", LocalDate.of(2000, 2, 24)));
        people.add(new Person("Attila", LocalDate.of(1988, 2, 24), "Atis"));
        people.add(new Employee(1, new Department("Dev1", "Fejlesztői_csapat"),
                        "Csongor", LocalDate.of(1997, 10, 29)));
        people.add(new Employee(2, new Department("QA", "Quality_Assurance"),
                            "Zoltán", LocalDate.of(1997, 10, 29)));

        try(Formatter formatter = new Formatter("people.txt")) {
            for (Person person : people){
                formatter.format("%s\n", person.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nincs ilyen file");
        }

        System.out.println("*********");

        ArrayList<Person> personList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("people.txt"))){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] elements = line.split(";|,|\\[|\\]|\\=| ");
                ArrayList<String> lElemList = new ArrayList<>();
                for (String elem : elements){
                    lElemList.add(elem);
                }
                while(lElemList.remove(""));

                /*
                for(String str : lElemList){
                    if(str == ""){
                        System.out.println("null");
                    }
                    else {
                        System.out.println(str);
                    }
                }*/

                System.out.println(lElemList);

                if(lElemList.get(0).equals("Person")){
                    if(lElemList.get(4) == null)
                        personList.add(new Person(lElemList.get(2),LocalDate.parse(lElemList.get(6))));
                    else
                        personList.add(new Person(lElemList.get(2),
                                LocalDate.parse(lElemList.get(6)), lElemList.get(6)));
                } else
                    personList.add(new Employee(Integer.parseInt(lElemList.get(2)), new Department(lElemList.get(5), lElemList.get(7)), lElemList.get(11),LocalDate.parse(lElemList.get(15))));


            }
        } catch (FileNotFoundException e) {
            System.out.println("nincs ilyen file");
        }

        System.out.println("*********");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CompanyObj.bin") )){
            for(Company company : companyList){
                oos.writeObject(company);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Program vége");
    }
}