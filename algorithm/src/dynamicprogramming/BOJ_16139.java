package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int[][] sum = new int[str.length()+1][26];

        for(int i=1 ; i<=str.length() ; i++) {
            char ch = str.charAt(i-1);
            int idx = ch - 'a';
            for(int j=0 ; j<26 ; j++) {
                sum[i][j] = sum[i-1][j];
            }
            sum[i][idx] += 1;
        }

        StringBuilder sb =  new StringBuilder();
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int idx = ch - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end+1][idx] - sum[start][idx]).append("\n");
        }
        System.out.println(sb);
    }
}
