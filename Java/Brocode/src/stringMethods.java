public class stringMethods {
    public static void main(String[] args) {

        String name = "Levente";

        boolean result = name.equals("Levente");
        boolean result2 = name.equalsIgnoreCase("levente");
        int length = name.length();
        char secondChar = name.charAt(2);
        int index = name.indexOf("e");
        boolean isEmpty = name.isEmpty();
        String upperCase = name.toUpperCase();
        String lowerCase = name.toLowerCase();

        String nameWithSpaces = "    L      ";
        String trim = name.trim();
        String replace = nameWithSpaces.replace(" ", "x");

        System.out.println(".equals \"Levente\"=\"Levente\" result: " + result);
        System.out.println(".equalsIgnoreCase \"Levente\"=\"levente\" result: "+ result2);
        System.out.println("length: "+length);
        System.out.println("secondChar: "+secondChar);
        System.out.println("index: "+index);
        System.out.println("isEmpty: "+isEmpty);
        System.out.println("upperCase: "+upperCase);
        System.out.println("lowerCase: "+lowerCase);
        System.out.println("trim: "+trim);
        System.out.println("replace: "+replace);
    }
}
