package oop;

public class oop {
    public static void main(String[] args) {
        // object = instance of a class that may contain attributes and methods
        // basically a bundle of defining methods and attributes, the characteristics of an object and what actions this object can preform

        // let's construct the object

        car myCar = new car();
        car mySecondCar = new car();

        System.out.println(myCar.model);
        System.out.println(myCar.make+"\n");

        System.out.println(mySecondCar.model);
        System.out.println(mySecondCar.make);

        //myCar.drive();
        //myCar.brake();


    }
}
