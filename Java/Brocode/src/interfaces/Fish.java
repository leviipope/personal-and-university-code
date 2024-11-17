package interfaces;

public class Fish implements Prey,Predator{

    @Override
    public void hunt() {
        System.out.println("Fish hunting");
    }

    @Override
    public void flee() {
        System.out.println("Fish fleeing");
    }
}
