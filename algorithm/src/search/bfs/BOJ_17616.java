package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class BOJ_17616 {
    static int n, m, x;
    static ArrayList<Integer>[] wins;
    static ArrayList<Integer>[] loses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        wins = new ArrayList[n+1];
        loses = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            wins[i] = new ArrayList<>();
            loses[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int win = Integer.parseInt(st.nextToken());
            int lose = Integer.parseInt(st.nextToken());

            wins[win].add(lose);
            loses[lose].add(win);
        }

        bfs();
    }
    private static void bfs() {
        int wr = 1;
        int lr = n;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[x] = true;
        queue.add(x);

        // lr
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int next : wins[temp]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    lr--;
                }
            }
        }
        queue = new LinkedList<>();
        visited = new boolean[n+1];
        queue.add(x);
        visited[x] = true;

        // wr
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int next : loses[temp]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    wr++;
                }
            }
        }

        System.out.println(wr + " " + lr);
    }
}
