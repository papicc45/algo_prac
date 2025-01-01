package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_7983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Assignment> assignments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            assignments.add(new Assignment(day, deadline));
        }
        Collections.sort(assignments);
        int result = Integer.MAX_VALUE;
        for(int i=n-1 ; i>=0 ; i--) {
            Assignment asg = assignments.get(i);
            result = Math.min(result, asg.deadline);
            result -= asg.day;
        }

        System.out.println(Math.max(0, result));
    }

    static class Assignment implements Comparable<Assignment> {
        int day;
        int deadline;

        public Assignment(int day, int deadline) {
            this.day = day;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Assignment o) {
            return this.deadline - o.deadline;
        }
    }
}
