package methodOverriding;

public class Dog extends Animal {

    @Override // isn't necessary but its considered good practice
    void speak(){
        System.out.println("WOOF");
    }

}
