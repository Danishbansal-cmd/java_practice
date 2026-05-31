package triangle;

import java.util.Arrays;
import java.util.Scanner;

public class AnglesOfATriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter triangle sides: ");
        int[] sides = new int[3];
        for(int i = 0; i < 3; i++){
            sides[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(internalAngles(sides)));
    }

    static double[] internalAngles(int[] sides){

        // Step 1: Check if a valid triangle can be formed using given sides
        if(!isValidTriangleUsingSides(sides)){
            return new double[]{}; // return empty if invalid
        }

        // Extract sides
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];

        // Step 2: Compute angles using Law of Cosines
        // Law of Cosines:
        // a² = b² + c² - 2bc cos(A)
        // b² = a² + c² - 2ac cos(B)
        // c² = a² + b² - 2ab cos(C)

        double A = angle(b, c, a); // angle opposite to side a
        double B = angle(a, c, b); // angle opposite to side b
        double C = angle(a, b, c); // angle opposite to side c

        double[] res = new double[]{A, B, C};

        // Step 3: Sort angles in non-decreasing order
        Arrays.sort(res);

        return res;
    }


    // Helper function: computes angle using Law of Cosines
    // cos(θ) = (x² + y² - opposite²) / (2xy)
    // θ = acos( (x² + y² - opposite²) / (2xy) )
    static double angle(double x, double y, double opposite){

        double val = (x*x + y*y - opposite*opposite)/(2*x*y);

        // Clamp value to [-1, 1] to avoid floating point precision issues
        val = Math.max(-1, Math.min(1, val));

        // Convert from radians to degrees
        return Math.toDegrees(Math.acos(val));
    }

    // Check triangle validity using Heron's formula (area > 0)
    boolean isValidTriangleUsingArea(int[] sides){

        double semiPeri = (sides[0] + sides[1] + sides[2] ) / 2.0;

        // Heron's formula:
        // Area² = s(s-a)(s-b)(s-c)
        double area = semiPeri * (semiPeri - sides[0]) * (semiPeri - sides[1]) * (semiPeri - sides[2]);

        return area > 0;
    }

    // Check triangle validity using triangle inequality
    static boolean isValidTriangleUsingSides(int[] sides){
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        
        // Triangle inequality:
        // a + b > c, b + c > a, a + c > b
        if(a+b <= c || b+c <= a || a+c <= b){
            return false;
        }

        return true;
    }

    // Check triangle validity using coordinates (cross product / area method)
    static boolean isValidTriangleUsingPoints(int x1, int y1, int x2, int y2, int x3, int y3){

        // Area using cross product:
        // (x2 - x1)*(y3 - y1) - (x3 - x1)*(y2 - y1)
        int area = (x2 - x1)*(y3 - y1) - (x3 - x1)*(y2 - y1);
    
        // If area == 0 → collinear points → not a triangle
        return area != 0;
    }
}
