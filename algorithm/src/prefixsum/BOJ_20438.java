package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sum = new int[n+3];
        boolean[] sleep = new boolean[n+3];
        boolean[] attend = new boolean[n+3];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++) {
            int num = Integer.parseInt(st.nextToken());
            sleep[num] = true;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<q ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(sleep[num])
                continue;

            for(int j=num ; j<=n+2 ; j+=num) {
                if(!sleep[j]) {
                    attend[j] = true;
                }
            }
        }

        for(int i=3 ; i<=n+2 ; i++) {
            sum[i] = sum[i-1] + (attend[i] ? 0 : 1);
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(sum[e] - sum[s-1]);
        }

    }
}
