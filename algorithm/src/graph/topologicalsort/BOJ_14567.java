package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degree = new int[n+1];
        int[] result = new int[n+1];

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            degree[next]++;

            list[pre].add(next);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            if(degree[i] == 0) {
                queue.add(i);
                result[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for(int next : list[temp]) {
                degree[next]--;

                if(degree[next] == 0) {
                    queue.add(next);
                    result[next] = result[temp] + 1;
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
