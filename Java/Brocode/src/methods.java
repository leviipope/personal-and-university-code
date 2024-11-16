public class methods {
    public static void main(String[] args) {

        hello();
        String name = "Levi";
        int age = 19;
        nameMethod(name,age);

        int x = 3;
        int y = 4;

        int z = sum(x,y);
        System.out.println(z);

        System.out.println(sum(x,y));

    }

    static void hello() {
        System.out.println("Hello");
    }

    static void nameMethod(String n,int a) {
        System.out.println("Hello " + n + ", your age: "+ a);
    }

    static int sum(int a, int b) {
        int z = a + b;
        return z;
    }


}
