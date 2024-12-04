package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=0 ; tc<t; tc++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0 ; i<n ; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int[] arr = new int[n];
            int first = 0;
            int last = n-1;

            boolean fc = false;
            boolean lc = false;

            while (!queue.isEmpty()) {

                if(!fc) {
                    fc = true;
                    lc = false;
                    arr[first++] = queue.poll();
                } else if(!lc) {
                    lc = true;
                    fc = false;
                    arr[last--] = queue.poll();
                }
            }

            int max = Math.abs(arr[0] - arr[n-1]);
            for(int i=0 ; i<n-1 ; i++) {
                max = Math.max(max, Math.abs(arr[i] - arr[i+1]));
            }
            System.out.println(max);
        }
    }
}

