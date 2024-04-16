package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class BOJ_1826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        st = new StringTokenizer(br.readLine());
        int goal = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        int result = 0;
        while (true) {
            while (idx < n && list.get(idx)[0] <= fuel) {
                queue.add(list.get(idx)[1]);
                idx++;
            }

            if(!queue.isEmpty() && fuel < goal) {
                fuel += queue.poll();
                result++;
            } else {
                break;
            }
        }
        if(fuel >= goal) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }


    }
}
