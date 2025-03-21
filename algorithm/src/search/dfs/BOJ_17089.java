package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17089 {
    static int n;
    static int result = Integer.MAX_VALUE;
    static int[] cnt;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        cnt = new int[n+1];
        check = new boolean[n+1][n+1];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b] = true;
            check[b][a] = true;
            cnt[a]++;
            cnt[b]++;
        }

        for(int i=1 ; i<=n ; i++) {
            for(int j=i+1 ; j<=n ; j++) {
                if(check[i][j]) {
                    for(int k=j+1 ; k<=n ; k++) {
                        if(check[i][k] && check[k][j])
                            result = Math.min(result, cnt[i] + cnt[j] + cnt[k] - 6);
                    }
                }
            }
        }

        if(result == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(result);
    }
}
