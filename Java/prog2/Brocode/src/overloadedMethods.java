public class overloadedMethods {
    public static void main(String[] args) {
        // overloaded methods = have the same name but different parameters
        // method name + parameters = methods signature

        System.out.println(add(2,4));
        System.out.println(add(2,5,5));
        System.out.println(add(2,5,6,7));
        System.out.println(add(2.5,4.9));
        System.out.println(add(2.45,5.9191,5));
        System.out.println(add(2.852,5.989895,6.1,7));
    }

    static int add(int a, int b) {
        System.out.println("This is ov. method 1");
        return a + b;
    }

    static int add(int a, int b, int c) {
        System.out.println("This is ov. method 2");
        return a + b +c;
    }

    static int add(int a, int b, int c, int d) {
        System.out.println("This is ov. method 3");
        return a + b + c + d;
    }

    static double add(double a, double b) {
        System.out.println("This is ov. method 4");
        return a + b;
    }

    static double add(double a, double b, double c) {
        System.out.println("This is ov. method 5");
        return a + b +c;
    }

    static double add(double a, double b, double c, double d) {
        System.out.println("This is ov. method 6");
        return a + b + c + d;
    }



}
