import java.util.Random;

public class randomNumbers {
    public static void main(String[] args) {

        Random rand = new Random(); // an instance from the random class

        int x = rand.nextInt(); // int x = name_of_random_instance.nextInt();

        int y = rand.nextInt(6)+1;
        // generates number between 0 and 5, we need to add 1 to gen. num. between 1 and 6

        double z = rand.nextDouble(); // number between 0 and 1

        boolean w = rand.nextBoolean(); // true or false

        System.out.println("x = "+ x);
        System.out.println("y = "+ y);
        System.out.println("z = "+ z);
        System.out.println("w = "+ w);

    }
}