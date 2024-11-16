import java.util.ArrayList;

public class ArrayListInJava {
    public static void main(String[] args) {
        // ArrayList = a resizeable array,
        //             Element can be added and removed after compilation
        //             stores reference datatypes

        ArrayList<String> food = new ArrayList<String>();
        // use reference dataypes in <>
        // if you need to store primitive values then use the wrapper class of the prim. val. ex.: <Integer>

        food.add("pizza");
        food.add("apple");
        food.add("banana");

        for(int i=0; i<food.size(); i++){
            System.out.print(food.get(i)+" ");
        } System.out.println();

        // or

        for(String theFood : food){
            System.out.print(theFood+" ");
        } System.out.println();

        food.set(0, "sushi");
        food.remove(1);

        for(String theFood : food){
            System.out.print(theFood+" ");
        }

        food.clear();
        for(String theFood : food){
            System.out.print(theFood+" ");
        }
    }
}
