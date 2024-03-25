package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.DSAPrivateKeySpec;
import java.util.*;

public class BOJ_18405 {
    static int[] dx = {0, 0, -1 ,1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static boolean[][] visited;
    static int[][] map;
    static PriorityQueue<Virus> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        map = new int[n][n];
        queue = new PriorityQueue<>();

        for(int i=0 ; i<n ; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] != 0) {
                    queue.add(new Virus(map[i][j], i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<s ; i++) {
            BFS();
        }
        System.out.println(map[x-1][y-1]);
    }
    private static void BFS() {
        int size = queue.size();
        List<Virus> list = new ArrayList<>();
        for(int k=0 ; k<size ; k++) {
            Virus temp = queue.poll();
            int num = temp.num;
            int tx = temp.x;
            int ty = temp.y;

            visited[tx][ty] = true;
            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = num;
                        list.add(new Virus(map[nx][ny], nx, ny));
                    }
                }
            }
        }
        for(Virus virus : list) {
            queue.add(virus);
        }
    }

    static class Virus implements Comparable<Virus>{
        int num;
        int x;
        int y;

        public Virus(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Virus o) {
            return this.num - o.num;
        }
    }
}
