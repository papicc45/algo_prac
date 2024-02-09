package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18513 {
    static int n, k;
    static Queue<int[]> queue;
    static HashSet<Integer> visited;
    static int[] dx = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int water = Integer.parseInt(st.nextToken());
            queue.add(new int[] {water, 0});
            visited.add(water);
        }

        System.out.println(BFS());
    }
    public static long BFS() {
        long distance = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0 ; i<2 ; i++) {
                int nx = temp[0] + dx[i];

                if(!visited.contains(nx)) {
                    distance += (temp[1]+1);
                    count++;
                    visited.add(nx);
                    queue.add(new int[] {nx, temp[1] + 1});
                }
                if(count == k)
                    return distance;
            }
        }
        return distance;
    }
}
