package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11562 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            Arrays.fill(arr[i], 987654321);
            arr[i][i] = 0;
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int direct = Integer.parseInt(st.nextToken());

            arr[start][end] = 0;
            arr[end][start] = direct == 0 ? 1 : 0;
        }

        for(int k=1 ;k<=n ; k++) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    if(i == j)
                        continue;

                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(arr[start][end] + "\n");
        }
        System.out.println(sb.toString());
    }
}
