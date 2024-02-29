package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] grow = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;
        for(int i=0 ; i<n ; i++) {
            result += Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(grow);
        for(int i=0 ; i<n ; i++) {
            result += grow[i] * i;
        }
        System.out.println(result);
    }
}
