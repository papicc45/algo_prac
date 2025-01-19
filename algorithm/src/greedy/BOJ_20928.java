package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] loc = new int[n];
        int[] range = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            range[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(new int[] {loc[0], range[0], 0});
        visited[0] = true;

        int result = Integer.MAX_VALUE;
        int idx = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int ti = temp[0];
            int tr = temp[1];
            int tc = temp[2];

            if(ti + tr >= m) {
                result = Math.min(result, tc);
            }

            int ndx = idx + 1;
            for(int i=ndx ; i<n ; i++) {
                if(visited[i])
                    continue;

                if(ti + tr >= loc[i]) {
                    visited[i] = true;
                    queue.add(new int[] {loc[i], range[i], tc + 1});
                    idx = Math.max(idx, i);
                } else {
                    break;
                }
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
