public class arrays {
    public static void main(String[] args) {

        String[] cars = {"Camaro","Corvette","Tesla"};
        cars[0] = "Mustang";
        System.out.println(cars[0] + " " + cars[1]);

        String[] carsPredefined = new String[3];

        carsPredefined[0] = "Mustang2";
        carsPredefined[1] = "Corvette2";
        carsPredefined[2] = "Tesla2";

        for(int i = 0; i < carsPredefined.length; i++){
            System.out.print(carsPredefined[i] + " ");
        }
        System.out.println();

        for (String s : carsPredefined) {
            System.out.print(s + " ");
        }
        System.out.println();

        int[] nums = {1,2,3,4};
        for(int i : nums){
            System.out.print(i + " ");
        }

    }
}
