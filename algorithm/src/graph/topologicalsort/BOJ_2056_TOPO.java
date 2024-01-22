package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056_TOPO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n+1];

        int[] degree = new int[n+1];
        int[] times = new int[n+1];
        int[] result = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int preCount = Integer.parseInt(st.nextToken());
            degree[i] = preCount;

            if(degree[i] == 0) {
                queue.add(i);
                result[i] = time;
            }
            times[i] = time;
            for(int j=0 ; j<preCount ; j++) {
                int next = Integer.parseInt(st.nextToken());
                list[next].add(i);
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(Integer next : list[temp]) {
                result[next] = Math.max(result[next], result[temp] + times[next]);
                degree[next]--;

                if(degree[next] == 0)
                    queue.add(next);
            }
        }
        int answer = 0;
        for(int i=1 ; i<=n ; i++) {
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);

    }
}
