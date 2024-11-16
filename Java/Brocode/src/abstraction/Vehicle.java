package abstraction;

public abstract class Vehicle { // adds a layer of security, cant declare vehicle, only a child of it, because vehicle is too abstract

    abstract void go(); // can't add body, this forces us to implement go() into all children of Vehicle
}
