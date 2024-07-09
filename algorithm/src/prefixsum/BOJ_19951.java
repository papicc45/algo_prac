package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] copy = new int[n+2];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            copy[start] += k;
            copy[end+1] += (-k);
        }

        for(int i=1 ; i<=n ; i++) {
            copy[i] += copy[i-1];
        }

        for(int i=1 ; i<=n ; i++) {
            arr[i] += copy[i];
            System.out.print(arr[i] + " ");
        }
    }
}
