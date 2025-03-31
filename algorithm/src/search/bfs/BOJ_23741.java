package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_23741 {
    static ArrayList<Integer>[] list;
    static int n, m, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs();
    }
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, 0});
        boolean[][] visited = new boolean[n+1][y+1];
        visited[x][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int cnt = temp[1];

            for(int next : list[x]) {
                if(cnt + 1 <= y && !visited[next][cnt+1]) {
                    visited[next][cnt+1] = true;
                    queue.add(new int[] {next, cnt+1});
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            if(visited[i][y]) {
                res.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : res) {
            sb.append(i + " ");
        }

        System.out.println(res.size() == 0 ? "-1" : sb.toString());
    }
}
