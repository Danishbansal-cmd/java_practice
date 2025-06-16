import java.io.*;
import java.util.*;

class Hello {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PrintStream out = new PrintStream("output.txt");
        out.println("The number is: " + n);
        out.close();
    }
}
