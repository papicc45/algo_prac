package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17071 {
    static int n, k;
    static int[] move = {1, -1, 2};
    static int[] bro;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k)
            System.out.println(0);
        else
            System.out.println(bfs());
    }
    private static int bfs() {
        int size = 0;
        int time = 0;

        boolean[][] visited = new boolean[500001][2];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n][0] = true;

        while (!queue.isEmpty()) {
            size = queue.size();
            time++;
            int sniff = time % 2;

            k += time;

            if(k > 500000)
                return -1;

            for(int i=0 ; i<size ; i++) {
                int temp = queue.poll();

                for(int j=0 ; j<3 ; j++) {
                    int nx;
                    if(j == 2) {
                        nx = temp * move[j];
                    } else {
                        nx = temp + move[j];
                    }

                    if(nx>=0 && nx<=500000 && !visited[nx][sniff]) {
                        queue.add(nx);
                        visited[nx][sniff] = true;
                    }
                }
            }
            if(visited[k][sniff])
                return time;
        }
        return -1;
    }
}
