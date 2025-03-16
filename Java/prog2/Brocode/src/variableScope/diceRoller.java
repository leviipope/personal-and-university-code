package variableScope;

import java.util.Random;

public class diceRoller {

     /*
    diceRoller() {
        Random random = new Random();
        int num = 0;
        roll(random,num);
    }

    void roll(Random r, int num) {
        num = r.nextInt(6)+1;
        System.out.println(num);
    }
     */ // by passing the attributes the constructor, the roll method can be called
    // or we could set the cons. attr. to global (be defining them outside the constructor

    Random random = new Random();
    int num;

    diceRoller() {
        roll();
    }

    void roll() {
        num = random.nextInt(6)+1;
        System.out.println(num);
    }
}
