package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1944 {
    static int[] parent;
    static ArrayList<int[]> list;
    static PriorityQueue<Node> pq;
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new char[n][n];
        for(int i=0 ; i<n ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<n ; j++) {
                map[i][j] = arr[j];
                if(map[i][j] == 'S' || map[i][j] == 'K') {
                    list.add(new int[] {i, j});
                }
            }
        }
        pq = new PriorityQueue<>();
        for(int i=0 ; i<m+1 ; i++) {
            bfs(i, list.get(i)[0], list.get(i)[1]);
        }

        parent = new int[m+1];
        for(int i=0 ; i<=m ; i++)
            parent[i] = i;

        int cnt = 0;
        int result = 0;
        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            if(find(temp.start) != find(temp.end)) {
                union(temp.start, temp.end);
                result += temp.len;
                cnt++;
            }
        }

        if(cnt != m)
            System.out.println(-1);
        else
            System.out.println(result);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;
    }
    private static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }
    private static void bfs(int idx, int x, int y) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int len = temp[2];

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if(map[nx][ny] == '1') continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if(map[nx][ny] == 'S' || map[nx][ny] == 'K') {
                    for(int j=0 ; j<m+1 ; j++) {
                        if(nx == list.get(j)[0] && ny == list.get(j)[1]) {
                            pq.add(new Node(idx, j, len + 1));
                        }
                    }
                } else if(map[nx][ny] == '0') {
                    queue.add(new int[] {nx, ny, len + 1});
                }
            }
        }
    }
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int len;

        public Node(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            return this.len - o.len;
        }
    }
}
