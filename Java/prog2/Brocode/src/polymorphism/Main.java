package polymorphism;

import accessModifiers.package1.B;

public class Main {
    public static void main(String[] args) {
        // polymorphism = poly= many, morph = form
        //                The ability of an object to identify as more than one type

        Car car = new Car();
        Boat boat = new Boat();
        Bicycle bicycle = new Bicycle();

        Vehicle[] racers = {car,bicycle,boat}; // car, boat, bicycle also identify as vehicles

        /*
        car.go();
        boat.go();
        bicycle.go();
        */

        for(Vehicle v : racers){
            v.go();
        }





    }
}
