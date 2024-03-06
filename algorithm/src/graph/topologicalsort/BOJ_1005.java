package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] result = new int[n+1];
            int[] value = new int[n+1];
            int[] degree = new int[n+1];
            ArrayList<Integer>[] list = new ArrayList[n+1];
            for(int i=0 ; i<=n ; i++)
                list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=1 ; i<=n ; i++) {
                result[i] = Integer.parseInt(st.nextToken());
                value[i] = result[i];
            }

            for(int i=0 ; i<k ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[start].add(end);
                degree[end]++;
            }
            int w = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for(int i=1 ; i<=n ; i++) {
                if(degree[i] == 0)
                    queue.add(i);
            }
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                for(Integer next : list[temp]) {
                    degree[next]--;
                    result[next] = Math.max(result[next], result[temp] + value[next]);

                    if(degree[next] == 0)
                        queue.add(next);
                }
            }

            System.out.println(result[w]);
        }
    }
}
