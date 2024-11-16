package constructors;

public class human {

    String name;
    int age;
    double weight;

    human(String name, int age, double weight){                 // this is the constructor
        this.name = name; // pretend that "this" means the objects name, in this case: human1.name
        this.age = age;
        this.weight = weight;
    }

    void eat(){
        System.out.println(this.name + " is eating...");
    }
    void sleep(){
        System.out.println(this.name + " is sleeping...");
    }
}
