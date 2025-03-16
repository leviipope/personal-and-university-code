package toString;

public class toString {
    public static void main(String[] args) {

        // toString() = special method that all objects inherit,
        //              that return a string that "textually represents" an object.
        //              can be used implicitly and explicitly

        Car car = new Car();

        System.out.println(car); // memory address (before overriding toString method, it implicitly already calls toString()
        System.out.println(car.toString()); // does the same as above, as mentioned

        System.out.println(car.toString()); //explicit
        System.out.println(car); // implicit




    }
}
