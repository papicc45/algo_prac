package search.dfs;

import java.util.Scanner;

public class BOJ_2023 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    public static void DFS(int number, int depth) {
        if(depth == n) {
            if(isPrime(number)) {
                System.out.println(number);
                return;
            }
        }

        for(int i=1 ; i<=9 ; i+=2) {
            int next = number * 10 + i;
            if(isPrime(next)) {
                DFS(next, depth + 1);
            }
        }
    }
    public static boolean isPrime(int number) {
        for(int i=2 ; i<number/2 ; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
