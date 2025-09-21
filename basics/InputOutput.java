package basics;
import java.util.*;

public class InputOutput {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();

        // these are the wrapper classes around the primitive data types
        // which have some methods and stored in heap, little heavy than primitive
        Byte nextByte = sc.nextByte();
        Short nextShort = sc.nextShort();
        
        // 4bytes
        Integer nextInt = sc.nextInt();

        // 8bytes
        Long nextLong = sc.nextLong();

        // 8bytes
        Double nextDouble = sc.nextDouble();

        // float 4bytes - 1bit for sign, 8bits for power of 2, 23bits for mantisaa
        Float nextFloat = sc.nextFloat();

        // 1bit
        Boolean nextBoolean = sc.nextBoolean();
        sc.close();

        System.out.println(nextLine + " this the value");
        System.out.println(nextByte + " this the value");
        System.out.println(nextShort + " this the value");
        System.out.println(nextInt + " this the value");
        System.out.println(nextLong + " this the value");
        System.out.println(nextDouble + " this the value");
        System.out.println(nextFloat + " this the value");
        System.out.println(nextBoolean + " this the value");




        // these are primitive types stored directly in stack
        // no extra methods, fast and lightweight
        char ch1 = 's';
        byte b1 = 34;
        short s1 = 456;
        int int1 = 43;
        long l1 = 229384028;
        float f1 = -3.5e30f;
        double d1 = -334.0934345365;
        boolean bool1 = true;

    }
}


