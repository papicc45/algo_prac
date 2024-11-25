package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_25391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for(int i=0 ; i<n ; i++) {
            queue.add(new int[] {arr[i][0], arr[i][1]});
        }

        long result = 0;
        for(int i=0 ; i<k ; i++) {
            int[] temp = queue.poll();
            result += temp[0];
            set.add(temp[0]);
        }
        queue.clear();
        queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for(int i=0 ; i<n ; i++) {
            queue.add(new int[] {arr[i][0], arr[i][1]});
        }

        while (!queue.isEmpty()) {
            if(m == 0)
                break;
            int[] temp = queue.poll();

            if(set.contains(temp[0]))
                continue;

            result += temp[0];
            set.add(temp[0]);
            m--;
        }

        System.out.println(result);
    }
}
