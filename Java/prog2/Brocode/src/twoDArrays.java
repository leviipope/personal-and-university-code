public class twoDArrays {
    public static void main(String[] args) {

        String[][] cars = new String[3][3];

        cars[0][0] = "Suzuki";
        cars[0][1] = "BMW";
        cars[0][2] = "Silverado";
        cars[1][0] = "Mercedes";
        cars[1][1] = "Lexus";
        cars[1][2] = "Volkswagen";
        cars[2][0] = "Ferrari";
        cars[2][1] = "Honda";
        cars[2][2] = "Audi";

        for (int i = 0; i < cars.length; i++) {
            for (int j = 0; j < cars[i].length; j++) {
                System.out.print(cars[i][j] + " ");
            }
            System.out.println();
        }


    }
}
