package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1956 {
    static int INF = 4000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n+1][n+1];
        int[][] arr2 = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(i == j)
                    continue;

                arr1[i][j] = INF;
            }
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            arr1[start][end] = len;
        }

        for(int k=1 ; k<=n ; k++) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    if(arr1[i][k] != 0 && arr1[k][j] != 0) {
                        arr1[i][j] = Math.min(arr1[i][j], arr1[i][k] + arr1[k][j]);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(i == j)
                    continue;

                if(arr1[i][j] != INF && arr1[i][j] != 0 && arr1[j][i] != INF && arr1[j][i] != 0) {
                    result = Math.min(result, arr1[i][j] + arr1[j][i]);
                }
            }
        }
        if(result != Integer.MAX_VALUE) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }
    }
}
