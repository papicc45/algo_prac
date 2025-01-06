package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_30827 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Meeting> queue = new PriorityQueue<>();
        int[] rooms = new int[k];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.add(new Meeting(start, end));
        }

        int result = 0;
        while (!queue.isEmpty()) {
            Meeting meeting = queue.poll();
            int idx = 0;
            int min = Integer.MAX_VALUE;
            for(int i=0 ; i<k ; i++) {
                int diff = meeting.start - rooms[i];
                if(diff <= 0) continue;

                if(min > diff) {
                    idx = i;
                    min = diff;
                }
            }
            if(min != Integer.MAX_VALUE) {
                rooms[idx] = meeting.end;
                result++;
            }
        }
        System.out.println(result);

    }
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }
}
