package encapsulationGettersSetters;

public class Main {
    public static void main(String[] args) {
        // encapsulation = attributes of a class will be hidden or private,
        //                 Can be accessed only through methods (getters & setters)
        //                 You should make attributes private if you don't have a reason to make them public/protected

        Car car = new Car("Chevi","Camaro",2021);

        car.setYear(2010);

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());



    }
}
