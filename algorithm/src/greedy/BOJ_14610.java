package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[] solve = new int[n];
        boolean[] check = new boolean[m];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            solve[i] = Integer.parseInt(st.nextToken());
            if(solve[i] == m || solve[i] == 0) {
                System.out.println("NO");
                return;
            }
            for(int j=0 ; j<m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    solve[i]--;

            }
        }

        for(int j=0 ; j<m ; j++) {
            int cnt = 0;
            for(int i=0 ; i<n ; i++) {
                if(arr[i][j] == 0)
                    cnt++;
                else if(arr[i][j] == 1)
                    check[j] = true;
            }
            if(cnt == n) {
                System.out.println("NO");
                return;
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(check[j]) continue;

                if(arr[i][j] == -1 && !check[j] && solve[i] > 0) {
                    check[j] = true;
                    arr[i][j] = 1;
                    solve[i]--;
                }
            }
        }

        for(int i=0 ; i<m ; i++) {
            if(!check[i]) {
                System.out.println("NO");
                return;
            };
        }
        System.out.println("YES");


    }
}
