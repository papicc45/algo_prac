package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.zip.DataFormatException;

public class BOJ_1261 {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] miro;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];
        miro = new int[m][n];


        for(int i=0 ; i<m ; i++) {
            String[] str = br.readLine().split("");
            for(int j=0 ; j<n ; j++) {
                miro[i][j] = Integer.parseInt(str[j]);
            }
        }

        BFS();
        System.out.println(result);
    }
    private static void BFS() {
        PriorityQueue<Algo> queue = new PriorityQueue<>();
        queue.add(new Algo(0, 0, 0));

        while (!queue.isEmpty()) {
            Algo temp = queue.poll();
            int tx = temp.tx;
            int ty = temp.ty;

            if(tx == m-1 && ty == n-1) {
                result = temp.count;
            }
            if(visited[tx][ty])
                continue;

            visited[tx][ty] = true;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n) {
                    if(!visited[nx][ny]) {
                        if(miro[nx][ny] == 1) {
                            queue.add(new Algo(nx, ny, temp.count + 1));
                        } else {
                            queue.add(new Algo(nx, ny, temp.count));
                        }
                    }
                }
            }
        }
    }
}

class Algo implements Comparable<Algo> {
    int tx;
    int ty;
    int count;

    public Algo(int tx, int ty, int count) {
        this.tx = tx;
        this.ty = ty;
        this.count = count;
    }

    @Override
    public int compareTo(Algo o) {
        return this.count - o.count;
    }
}