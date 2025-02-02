package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19538 {
    static int n;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }


        StringTokenizer st;
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int k = Integer.parseInt(st.nextToken());
                if(k == 0) break;

                list[i].add(k);
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] first = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }

        bfs(first);
    }
    private static void bfs(int[] first) {
        Queue<Integer> queue = new LinkedList<>();
        int[] time = new int[n+1];
        int[] cnt = new int[n+1];

        Arrays.fill(time, -1);

        for(int i=0 ; i<first.length ; i++) {
            time[first[i]] = 0;
            queue.add(first[i]);
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int next : list[temp]) {
                cnt[next]++;

                if(time[next] == -1 && (list[next].size()+1) / 2 <= cnt[next]) {
                    queue.add(next);
                    time[next] = time[temp] + 1;
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            System.out.print(time[i] + " ");
        }
    }
}
