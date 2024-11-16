package overloadedConstructors;

public class pizza {

    String bread;
    String topping;
    String size;
    String sauce;

    pizza(String bread, String topping, String size, String sauce) {
        this.bread = bread;
        this.topping = topping;
        this.size = size;
        this.sauce = sauce;
    }

    pizza(String bread, String size, String sauce) {
        this.bread = bread;
        this.size = size;
        this.sauce = sauce;
    }

    pizza(String bread, String size) {
        this.bread = bread;
        this.size = size;
    }
}
