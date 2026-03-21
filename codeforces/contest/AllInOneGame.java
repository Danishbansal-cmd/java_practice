package codeforces.contest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class DamageIndex {
    int d;
    int i;

    DamageIndex(int d, int i) {
        this.d = d;
        this.i = i;
    }
}

public class AllInOneGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intputNumber = sc.nextInt();

        for (int i = 0; i < intputNumber; i++) {
            int bullets = sc.nextInt();
            int enemyHealth = sc.nextInt();
            int timeToReload = sc.nextInt();

            int[] bulletsDamage = new int[bullets];
            for (int j = 0; j < bullets; j++) {
                bulletsDamage[j] = sc.nextInt();
            }

            allInOneGame(bullets, enemyHealth, timeToReload, bulletsDamage);

        }

        sc.close();
    }

    static void allInOneGame(int bullets, int enemyHealth, int timeToReload, int[] bulletsDamage) {
        Deque<DamageIndex> maxDeq = new ArrayDeque<>();
        for (int i = 0; i < bullets; i++) {
            int damage = bulletsDamage[i];

            // max deque for the damage, (decreasing order)
            while (!maxDeq.isEmpty() && maxDeq.peekLast().d <= damage) {
                maxDeq.pollLast();
            }
            maxDeq.offerLast(new DamageIndex(damage, i));
        }

        for (int i = 0; i < bullets; i++) {
            if (!maxDeq.isEmpty()) {
                if (bulletsDamage[i] != maxDeq.peekFirst().d) {
                    int temp = bulletsDamage[i];
                    bulletsDamage[i] = maxDeq.peekFirst().d;
                    bulletsDamage[maxDeq.peekFirst().i] = temp;
                    break;
                }
            } else {
                break;
            }
        }
    }
}
