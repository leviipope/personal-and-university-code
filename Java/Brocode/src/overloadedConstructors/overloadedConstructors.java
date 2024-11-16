package overloadedConstructors;

public class overloadedConstructors {
    public static void main(String[] args) {
        // overl. cons. = multiple cons. in a class w/ the same name, but diff. parameters
        // reminder: name + param. = signature

        pizza pizza1 = new pizza("thick","pepperoni","large","ketchup");

        System.out.println("Here are the ingredients of your pizza: "+ pizza1.bread + " " + pizza1.topping + " " + pizza1.size + " " + pizza1.sauce+ ", enjoy!");

        pizza pizza2 = new pizza("slim","large");
        System.out.println("Here are the ingredients of your pizza: "+ pizza2.bread + " " + pizza2.topping + " " + pizza2.size + " " + pizza2.sauce+ ", enjoy!");

        pizza pizza3 = new pizza("cheesy","large", "tomato");
        System.out.println("Here are the ingredients of your pizza: "+ pizza3.bread + " " + pizza3.topping + " " + pizza3.size + " " + pizza3.sauce+ ", enjoy!");


    }
}
