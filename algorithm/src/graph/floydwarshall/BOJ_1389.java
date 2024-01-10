package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(i == j)
                    continue;

                arr[i][j] = 100000001;
            }
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int friends1 = Integer.parseInt(st.nextToken());
            int friends2 = Integer.parseInt(st.nextToken());

            arr[friends2][friends1] = 1;
            arr[friends1][friends2] = 1;
        }

        for(int k=1 ; k<=n ; k++) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    if(arr[i][k] != 0 && arr[k][j] != 0) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1 ; i<=n ; i++) {
            int sum = 0;
            for(int j=1 ; j<=n ; j++) {
                sum += arr[i][j];
            }

            if(min > sum) {
                result = i;
                min = sum;
            }
        }
        System.out.println(result);
    }
}
