package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        boolean[] dp = new boolean[40001];
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<n ; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            for(int j=1 ; j<=15000 ; j++) {
                if(!dp[j]) continue;

                if(j - arr[i] > 0) list.add(j - arr[i]);
                if(j + arr[i] < 15001) list.add(j + arr[i]);
                if(arr[i] - j > 0) list.add(arr[i] - j);
            }

            for(int num : list) {
                dp[num] = true;
            }
        }

        int q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(dp[num])
                System.out.print("Y ");
            else
                System.out.print("N ");
        }



    }
}
