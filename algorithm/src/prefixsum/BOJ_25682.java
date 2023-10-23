package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25682 {
    static char[][] chess;
    static int n, m, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chess = new char[n][m];
        for(int i=0 ; i<n ; i++) {
            String str = br.readLine();
            chess[i] = str.toCharArray();
        }


        System.out.println(Math.min(divideChess('B'), divideChess('W')));


    }
    static int divideChess(char color) {
        int[][] arr = new int[n+1][m+1];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if((i + j)%2 == 0) {
                    arr[i+1][j+1] = arr[i][j+1] + arr[i+1][j] - arr[i][j] + (chess[i][j] != color ? 1 : 0);
                } else {
                    arr[i+1][j+1] = arr[i][j+1] + arr[i+1][j] - arr[i][j] + (chess[i][j] == color ? 1 : 0);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=1 ; i<=n-k+1 ; i++) {
            for(int j=1 ; j<=m-k+1 ; j++) {
                result = Math.min(result, arr[i+k-1][j+k-1] - arr[i-1][j+k-1] - arr[i+k-1][j-1] + arr[i-1][j-1]);
            }
        }

        return result;
    }
}
