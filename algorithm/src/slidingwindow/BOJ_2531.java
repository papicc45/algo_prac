package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int result = Integer.MIN_VALUE;
        while (idx < n) {
            Set<Integer> set = new HashSet<>();
            for(int i=idx ; i<idx+k ; i++) {
                set.add(i >= n ? arr[i % n] : arr[i]);
            }
            idx++;
            result = Math.max(result, set.contains(c) ? set.size() : set.size() + 1);
        }
        System.out.println(result);
    }
}
