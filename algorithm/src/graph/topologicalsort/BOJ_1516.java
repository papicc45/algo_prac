package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n+1];
        int[] builds = new int[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] degree = new int[n+1];

        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1 ; i<=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            builds[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if(next == -1)
                    break;

                list[next].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            if(degree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for(int next : list[temp]) {
                degree[next]--;
                answer[next] = Math.max(answer[next], answer[temp] + builds[temp]);
                if(degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        for(int i=1 ; i<=n ; i++) {
            System.out.println(answer[i] + builds[i]);
        }
    }
}
