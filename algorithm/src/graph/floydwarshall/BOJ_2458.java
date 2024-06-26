package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for(int i=0 ; i<m ;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = 1;
            arr[end][start] = 2;
        }

        for(int k=1 ; k<=n ; k++) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    if(arr[i][k] == 1 && arr[k][j] == 1)
                        arr[i][j] = 1;

                    if(arr[i][k] == 2 && arr[k][j] == 2)
                        arr[i][j] = 2;
                }
            }
        }

        int result = 0;
        for(int i=1; i <=n ; i++) {
            boolean check = false;
            for(int j=1 ; j<=n ; j++) {
                if(i != j && arr[i][j] == 0) {
                    check = true;
                }
            }
            if(!check)
                result++;
        }
        System.out.println(result);
    }
}
