package inheritance;

public class inheritance {
    public static void main(String[] args) {
        // inheritance = one class acquires, the attributes and methods of another

        // car and bicycle are subclasses (child classes) of the vehicle class (which is a superclass aka. parent class)

        Car car = new Car();
        car.go(); // the car received the go method from vehicle

        Bicycle bicycle = new Bicycle();
        bicycle.stop(); // bicycle inherited stop from vehicle

        System.out.println(car.price);
        System.out.println(bicycle.price);

        System.out.println(car.wheels);
        System.out.println(bicycle.pedals);
    }
}
