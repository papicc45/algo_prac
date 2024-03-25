package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16928 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        arr = new int[101];
        for(int i=1 ; i<=100 ; i++) {
            arr[i] = i;
        }

        for(int i=0 ; i<num ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.println(BFS(1));

    }
    private static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] counts = new int[101];

        while (true) {
            int temp = queue.poll();

            for(int i=1 ; i<=6 ; i++) {
                int next = temp + i;

                if(next > 100)
                    continue;

                if(counts[arr[next]] == 0) {
                    counts[arr[next]] = counts[temp] + 1;
                    queue.add(arr[next]);
                }

                if(arr[next] == 100)
                    return counts[arr[next]];
            }
        }
    }
}
