package superKeyword;

public class superKeyword {
    public static void main(String[] args) {

        // super = keyword refers to the superclass (parent) of an object
        //         very similar to the "this" keyword

        Hero hero1 = new Hero("Spider man",14,"webs");
        //System.out.println(hero1.name + " " + hero1.age + " " + hero1.power);

        Hero hero2 = new Hero("Super man",300,"everything");

        System.out.println(hero1.toString());
        System.out.println(hero2.toString());


    }
}
