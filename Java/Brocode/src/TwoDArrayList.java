import java.util.ArrayList;

public class TwoDArrayList {
    public static void main(String[] args) {

        ArrayList<String> bakeryList = new ArrayList();
        bakeryList.add("pasta");
        bakeryList.add("garlic bread");
        bakeryList.add("donuts");

        ArrayList<String> produceList = new ArrayList();
        produceList.add("tomatoes");
        produceList.add("cucumber");
        produceList.add("pepper");

        ArrayList<String> drinkList = new ArrayList();
        drinkList.add("water");
        drinkList.add("cola");

        System.out.println(bakeryList);
        System.out.println(bakeryList.get(2));
        System.out.println(produceList);
        System.out.println(drinkList);

        ArrayList<ArrayList<String>> groceryList = new ArrayList();

        groceryList.add(bakeryList);
        groceryList.add(produceList);
        groceryList.add(drinkList);
        System.out.println(groceryList);
        System.out.println(groceryList.get(2));
        System.out.println(groceryList.get(1).get(1));


    }
}
