package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int n, k;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited[n] = true;
        BFS(n, 0);

    }
    public static void BFS(int number, int seconds) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {number, seconds});
        while (true) {
            int[] temp = queue.poll();

            if(temp[0] == k) {
                System.out.println(temp[1]);
                break;
            }
            if(temp[0]*2 <= 100000 && !visited[temp[0]*2]) {
                queue.add(new int[] {temp[0]*2, temp[1]+1});
                visited[temp[0]*2] = true;
            }
            if(temp[0]-1 >= 0 && !visited[temp[0]-1]) {
                queue.add(new int[] {temp[0]-1, temp[1]+1});
                visited[temp[0]-1] = true;
            }
            if(temp[0]+1 <= 100000 && !visited[temp[0]+1]) {
                queue.add(new int[] {temp[0]+1, temp[1]+1});
                visited[temp[0]+1] = true;
            }
        }
    }
}
