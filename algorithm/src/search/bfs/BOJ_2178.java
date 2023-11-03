package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static int[][] counts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        counts = new int[n][m];

        for(int i=0 ; i<n ; i++) {
            String[] str = br.readLine().split("");
            for(int j=0 ; j<str.length ; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        BFS(0, 0, 0);
        System.out.println(counts[n-1][m-1]+1);

    }
    public static void BFS(int tx, int ty, int count) {
        Queue<Node> queue = new LinkedList<>();
        visited[tx][ty] = true;
        queue.add(new Node(tx, ty, count));

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

//            if(temp.x == n-1 && temp.y == m-1)
//                return;
            for(int i=0 ; i<4 ; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        counts[nx][ny] = temp.count + 1;
                        queue.add(new Node(nx, ny, temp.count + 1));
                    }
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
