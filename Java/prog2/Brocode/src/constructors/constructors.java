package constructors;

public class constructors {
    public static void main(String[] args) {

        // constructor = special method that is called when an object is created

        human human1 = new human("Rick",25,80.6);
        human human2 = new human("Bob",15,30.6);

        System.out.println(human1.name);
        human2.eat();
        human1.sleep();
    }
}
