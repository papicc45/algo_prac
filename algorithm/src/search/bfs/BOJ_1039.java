package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1039 {
    static boolean[][] visited;
    static int n;
    static int k;
    static int len;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        len = String.valueOf(n).length();
        bfs();

        System.out.println(result);
    }
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[1000001][k+1];
        queue.add(new int[] {n, 0});
        visited[n][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            if(temp[1] == k) {
                result = Math.max(result, temp[0]);
                continue;
            }

            for(int i=0 ; i<len ; i++) {
                for(int j=0 ; j<len ; j++) {
                    if(i == j) continue;

                    int next = change(temp[0], i, j);

                    if(next == 0) continue;
                    if(visited[next][temp[1] + 1]) continue;

                    queue.add(new int[] {next, temp[1] + 1});
                    visited[next][temp[1] + 1] = true;
                }
            }
        }
    }
    private static int change(int num, int i, int j) {
        char[] arr = String.valueOf(num).toCharArray();

        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;

        if(arr[0] == '0') return 0;
        return Integer.parseInt(new String(arr));
    }
}
