import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] m = new double[3][3];

        System.out.println("Kérem egy 3x3 mátrix elemeit: ");
        System.out.print("[1,1]: ");

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                double d = sc.nextDouble();
                m[i][j] = d;
                if (i==2 && j==2) continue;
                System.out.print("[");
                if(j==2){
                    System.out.print(i+2);
                    System.out.print(";");
                    System.out.print(1);
                }
                else{
                    System.out.print(i+1);
                    System.out.print(";");
                    System.out.print(j+2);
                }
                System.out.print("]: ");
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(m[i][j] + "; ");
            }
            System.out.println();
        }

        double d = m[0][0] * m[1][1] * m[2][2] +
                m[1][0] * m[2][1] * m[0][2] +
                m[2][0] * m[0][1] * m[1][2] -
                m[2][0] * m[1][1] * m[0][2] -
                m[1][0] * m[0][1] * m[2][2] -
                m[0][0] * m[2][1] * m[1][2];
        System.out.println("determinánsa: " + d);
        sc.close();
    }
}