package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        PriorityQueue<Pool> queue = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());

            queue.add(new Pool(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int lastPlank = 0;
        int result = 0;
        while(!queue.isEmpty()) {
            Pool temp = queue.poll();

            int start = temp.start;
            int end = temp.end;

            if(lastPlank < start) {
                lastPlank = start;
            }

            while(lastPlank < end) {
                lastPlank += l;
                result++;
            }
        }
        System.out.println(result);
    }
}

class Pool implements Comparable<Pool> {
    int start;
    int end;

    public Pool(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pool o) {
        return this.start - o.start;
    }
}
