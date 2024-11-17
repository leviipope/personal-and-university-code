package dynamicPolymorphism;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // dynamic = after compilation (during runtime)

        // ex. A corvette is a: corvette, and a car, and a vehicle, and an object

        Scanner sc = new Scanner(System.in);
        Animal animal;

        System.out.println("Enter the name of the animal you want: ");
        System.out.print("1 = dog | 2 = cat");
        int choice = sc.nextInt();

        if(choice == 1) {
            animal = new Dog();
            animal.speak();
        } else if(choice == 2) {
            animal = new Cat();
            animal.speak();
        }
        else {
            animal = new Animal();
            System.out.println("Invalid choice");
            animal.speak();
        }



    }
}
