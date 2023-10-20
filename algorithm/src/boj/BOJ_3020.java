package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bottom = new int[m+2];
        int[] top = new int[m+2];

        for(int i=1 ; i<=(n)/2 ; i++) {
            int b = Integer.parseInt(br.readLine());
            int t = m - Integer.parseInt(br.readLine()) + 1;

            bottom[b]++;
            top[t]++;
        }
        for(int i=1 ; i<=m ; i++) {
            bottom[i] += bottom[i-1];
        }

        for(int i=m ; i>=1 ; i--) {
            top[i] += top[i+1];
        }


        for(int i=0 ; i<bottom.length ; i++) {
            System.out.print(bottom[i] + " ");
        }
        System.out.println();
        for(int i=0 ; i<top.length ; i++) {
            System.out.print(top[i] + " ");
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=1 ; i<=m ; i++) {
            int diff = (bottom[m] - bottom[i-1]) + (top[1] - top[i+1]);

            if(diff < min) {
                min = diff;
                answer = 1;
            } else if(diff == min) {
                answer++;
            }
        }
        System.out.println();
        System.out.println(min + " "+ answer);

    }
}
