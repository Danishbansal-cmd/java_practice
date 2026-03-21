package codeforces.contest;

import java.util.Scanner;

public class StringRotationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for(int i = 0; i < intputNumber; i++){
            int sizeOfString = sc.nextInt();
            String inputString = sc.next();

            if(inputString.length() > sizeOfString){
                return;
            }else{
                System.out.println(stringRotationGame(sizeOfString, inputString));
            }
        }

        sc.close();
    }

    static int stringRotationGame(int sizeOfString, String s){
        int blocks = 1;


        for(int i = 1; i < sizeOfString; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                continue;
            }else{
                blocks++;
            }
        }


        if(blocks == sizeOfString){
            return blocks;
        }

        if(blocks < sizeOfString){
            if(s.charAt(0) == s.charAt(sizeOfString-1)){
                return blocks;
            }
        }

        return blocks+1;
    }
}

