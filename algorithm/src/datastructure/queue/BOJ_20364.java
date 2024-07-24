package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n  = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        int[] ducks = new int[q];
        int[] result = new int[q];
        for(int i=0 ; i<q ; i++) {
            ducks[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0 ; i<q ; i++) {
            int temp = ducks[i];

            int idx = 0;
            while (temp >= 2) {
                if(visited[temp]) {
                    idx = temp;
                }
                temp /= 2;
            }

            if(idx != 0) {
                result[i] = idx;
            } else {
                visited[ducks[i]] = true;
            }
        }

        for(int i=0 ; i<q ; i++) {
            System.out.println(result[i]);
        }
    }
}
