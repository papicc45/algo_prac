package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Job> queue = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());

            queue.add(new Job(time, deadline));
        }

        int result = Integer.MAX_VALUE;
        int sum = 0;
        boolean check = false;
        while (!queue.isEmpty()) {
            Job temp = queue.poll();
            sum += temp.time;
            result = Math.min(result, temp.end - sum);
            if(sum > temp.end) {
                check = true;
                break;
            }
        }
        if(check)
            System.out.println("-1");
        else
            System.out.println(result);

    }
}
class Job implements Comparable<Job>{
    int time;
    int end;

    public Job(int time, int end) {
        this.time = time;
        this.end = end;
    }

    @Override
    public int compareTo(Job o) {
        return this.end - o.end;
    }
}