package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];

        for(int i=1 ; i<=n ; i++)
            arr[i][i] = 1;

        for(int i=0 ; i<m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int product1 = Integer.parseInt(st.nextToken());
            int product2 = Integer.parseInt(st.nextToken());
            arr[product1][product2] = 1;
        }

        for(int k=1 ; k<=n ; k++) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    if(arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                        arr[j][i] = 1;
                    }
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            int  count = 0;
            for(int j=1 ; j<=n ; j++) {
                if(i != j && arr[i][j] == 0)
                    count++;
            }
            System.out.println(count);
        }
    }
}
