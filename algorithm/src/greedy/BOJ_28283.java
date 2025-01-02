package greedy;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_28283 {
    static int n, m, x, y;
    static ArrayList<Integer>[] list;
    static int[] money;
    static boolean[] visited;
    static PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        money = new int[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++)
            money[i] = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        st = new StringTokenizer(br.readLine());
        calHackTime(st);
        for(int i=1 ; i<=n ; i++) {
            if(!visited[i] && money[i] != 0) {
                System.out.println("-1");
                return;
            }
        }
        long result = 0;
        for(int i=0 ; i<x ; i++) {
            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }
    private static void calHackTime(StringTokenizer st) {
        Queue<long[]> queue = new LinkedList<>();
        visited = new boolean[n+1];
        for(int i=0 ; i<y ; i++) {
            int idx = Integer.parseInt(st.nextToken());
            queue.add(new long[] {idx, 1});
            visited[idx] = true;
        }

        while (!queue.isEmpty()) {
            long[] temp = queue.poll();
            int idx = (int)temp[0];
            long time = temp[1];

            for(int next : list[idx]) {
                if(!visited[next]) {
                    visited[next] = true;
                    pq.add(money[next] * time);
                    queue.add(new long[] {next, time + 1});
                }
            }
        }
    }

}
