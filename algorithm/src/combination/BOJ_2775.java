package combination;

import java.util.Scanner;

public class BOJ_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[k+1][n+1];

            for(int i=0 ; i<=n ; i++) {
                arr[0][i] = i;
            }

            for(int i=1 ; i<=k ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    arr[i][j] = arr[i][j-1] + arr[i-1][j];
                }
            }
            System.out.println(arr[k][n]);
            t--;
        }


    }
}
