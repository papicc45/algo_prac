package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1301 {
    static int n;
    static int[] arr;
    static long[][][][][][][] dp = new long[6][6][11][11][11][11][11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[5];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0 ; i<6 ; i++) {
            for(int j=0 ; j<6 ; j++) {
                for(int k=0 ; k<11 ; k++) {
                    for(int l=0 ; l<11 ; l++) {
                        for(int m=0 ; m<11 ; m++) {
                            for(int n=0 ; n<11 ; n++) {
                                Arrays.fill(dp[i][j][k][l][m][n], -1L);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(memo(0, 0, arr[0], arr[1], arr[2], arr[3], arr[4]));
    }
    private static long memo(int secondFromLast, int last, int a, int b, int c, int d, int e) {
        if(secondFromLast != 0 && last != 0 && secondFromLast == last)
            return 0;

        if(a < 0 || b < 0 || c < 0 || d < 0 || e < 0)
            return 0;

        if(a == 0 && b == 0 && c == 0 && d == 0 && e == 0)
            return 1;

        if(dp[secondFromLast][last][a][b][c][d][e] != -1)
            return dp[secondFromLast][last][a][b][c][d][e];

        long ans = 0;

        if(a > 0 && secondFromLast != 1)
            ans += memo(last, 1, a-1, b, c, d, e);
        if(b > 0 && secondFromLast != 2)
            ans += memo(last, 2, a, b-1, c, d, e);
        if(c > 0 && secondFromLast != 3)
            ans += memo(last, 3, a, b, c-1, d, e);
        if(d > 0 && secondFromLast != 4)
            ans += memo(last, 4, a, b, c, d-1, e);
        if(e > 0 && secondFromLast != 5)
            ans += memo(last, 5, a, b, c, d, e-1);

        return dp[secondFromLast][last][a][b][c][d][e] = ans;
    }
}
