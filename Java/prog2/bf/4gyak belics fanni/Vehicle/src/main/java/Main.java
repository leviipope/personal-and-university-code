import org.types.Bicycle;
import org.types.Car;
import org.types.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("id1");
        Vehicle v2 = new Vehicle("id2", 6);
        Vehicle v3 = new Vehicle("id2", 2);

        String testString = "id2";

        System.out.println(v1 + "=?" + v2 + "=" + v1.equals(v2));
        System.out.println(v2 + "=?" + v3 + "=" + v2.equals(v3));
        System.out.println(v2 + "=?" + testString + "=" + v2.equals(testString));

        Bicycle b1 = new Bicycle("id1");
        b1.setSize(28);
        System.out.println(v1 + "=?" + b1 + "=" + v1.equals(b1));

        Car c1 = new Car("NRY854", 72);
        c1.setMove();
        System.out.println(c1);
        c1.setStop();
        System.out.println(c1);
        c1.setParked();
        System.out.println(c1);

        Vehicle[] vehicles = new Vehicle[5];
        vehicles[0] = c1;
        vehicles[1] = v1;
        vehicles[2] = v2;
        vehicles[3] = v3;
        vehicles[4] = b1;

        for(var v : vehicles){
            System.out.println(v);
        }




    }
}
