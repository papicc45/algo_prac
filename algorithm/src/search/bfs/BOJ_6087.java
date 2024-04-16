package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6087 {
    static int w, h;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    static int[][][] mirrors;
    static boolean[][][] visited;
    static Node[] startEnd;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        startEnd = new Node[2];
        int index = 0;
        for(int i=0 ; i<h ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<w ; j++) {
                map[i][j] = arr[j];
                if(map[i][j] == 'C') {
                    startEnd[index++] = new Node(i, j, -1, -1);
                }
            }
        }
        bfs();
        System.out.println(min);
    }
    private static void bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        mirrors = new int[h][w][4];
        visited = new boolean[h][w][4];
        for(int i=0 ; i<h ; i++) {
            for(int j=0 ; j<w ; j++) {
                Arrays.fill(mirrors[i][j], Integer.MAX_VALUE);
            }
        }
        queue.add(new Node(startEnd[0].x, startEnd[0].y, startEnd[0].direct, startEnd[0].count));
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.x == startEnd[1].x && temp.y == startEnd[1].y) {
                min = Math.min(min, temp.count);
                continue;
            }

            for(int i=0 ; i<4 ; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int count = temp.direct == i ? temp.count : temp.count + 1;
                if(nx>=0 && ny>=0 && nx<h && ny<w) {
                    if(map[nx][ny] != '*' && !visited[nx][ny][i]) {
                        if(mirrors[nx][ny][i] > count) {
                            queue.add(new Node(nx, ny, i, count));
                            mirrors[nx][ny][i] = count;
                        }
                    }
                }
            }
        }
    }
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int direct;
        int count;

        public Node(int x, int y, int direct, int count) {
            this.x = x;
            this.y = y;
            this.direct = direct;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }
}
