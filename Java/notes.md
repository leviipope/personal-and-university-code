# Java
---
## Java Classes & Objects - [Youtube](https://www.youtube.com/watch?v=IUqKuGNasdM) 
### Class
A class can have 2 things: *variables* or *methods*.
When a varible is in a class, they're called **instance variables**.
You can have 0 or more methods in a class.

The class is a blueprint for creating objects.

##### Creating a class
Create class file in IntilliJ
```
-Pokemon.java-

public class Pokemon {

    String name;
    int level;

    void attack(){
        System.out.print(name + " attack!");
    }

}
```

##### Initializing an object
*Inside main.java*

Template:
classname objectname = new classname();

```
Pokemon p1 = new Pokemon();
p1.name = "Pikachu";
p1.level = 10;

System.out.print(p1.name + " " + p1.level);

Pokemon p2 = new Pokemon();
p1.name = "Eevee";
p1.level = 20;

p2.attack(); // returns -> Eevee attack!
```
***Note: Objects has their own set of variables***
So if we change the name of p1, it doesnt effect the name of p2.
Variables and methods are incapsulated inside the obejcts.

#### Constructors
