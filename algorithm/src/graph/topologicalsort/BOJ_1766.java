package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] degree = new int[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            degree[end]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1 ; i<=n ; i++) {
            if(degree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if(degree[temp] == 0) {
                System.out.print(temp + " ");
            }
            for(Integer next : list[temp]) {
                degree[next]--;

                if(degree[next] == 0)
                    queue.add(next);
            }
        }
    }
}
