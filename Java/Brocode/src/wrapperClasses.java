public class wrapperClasses {
    public static void main(String[] args) {
        // wrapper class = provides a way to use primitive datatypes as reference datatypes
        //                 reference datatypes contain useful methods
        //                 reference datatypes can be used with collections (ex. ArrayList)

        // primitive        // wrapper
        // boolean          // Boolean
        // char             // Character
        // int              // Integer
        // double           // Double
        // ...

        // autoboxing = the automatic conversion that the Java compiler makes between the primitive and their corresponding object wrapper class
        // unboxing = the reverse of autoboxing. Automatic conversion of wrapper class to primitive

        Boolean a = true;
        Character b = 'a';
        Integer c = 123;
        Double d = 123.456;
        String e = "Levi"; // string is a reference datatype be default
        // this was autoboxing

        if(a==false){
            System.out.println("truesky");
        }
        // unboxing

        // so basically it just slows your computer but u dint notice any change
    }
}
