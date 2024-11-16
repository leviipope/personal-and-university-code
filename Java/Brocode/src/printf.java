public class printf {
    public static void main(String[] args) {
        // printf() = control, format, display text to the console window
        //            two arguments = format string + (obj/variable/value)
        //            & [flags] [precision] [width] [conversion-character]

        System.out.printf("this is a format string %d",123);
        System.out.println();

        boolean myBoolean = true;
        char myChar = 'a';
        String myString = "Levi";
        int myInt = 1246543;
        double myDouble = 123.4554465465654;

        // [conversion-character]
        System.out.printf("%b"+"\n",myBoolean);
        System.out.printf("%c"+"\n",myChar);
        System.out.printf("%s"+"\n",myString);
        System.out.printf("%d"+"\n",myInt);
        System.out.printf("%f"+"\n",myDouble);

        // [width]
        System.out.printf("Hello %10s"+"\n",myString); //prints the string using up 10 characters totally, so Levi is 4chars + 6spaces

        // [precision]
        System.out.printf("Balance: %.2f"+"\n",myDouble);

        // [flags]
        // adds an effect to the output based on the flag added to format specifier
        // - : left-justify
        // + : output is a plus (+) or a minus (-) sign for a numeric value
        // 0 : numeric values are zero-padded
        // , : comma grouping separator if numbers > 1000

        System.out.printf("You have this much money: %-50f"+".\n",myDouble);
        System.out.printf("Balance: %+f"+"\n",myDouble);
        System.out.printf("Balance: %040f"+"\n",myDouble);
        System.out.printf("Balance: %,d"+"\n",myInt);


    }
}
