package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            list.add(new Lecture(deadline, pay));
        }

        Collections.sort(list);

        for(Lecture lecture : list) {
            int size = queue.size();

            if(size < lecture.deadline) {
                queue.add(lecture.pay);
            } else if(size == lecture.deadline) {
                int temp = queue.peek();

                if(temp < lecture.pay) {
                    queue.poll();
                    queue.add(lecture.pay);
                }
            }
        }
        int result = 0;
        while(!queue.isEmpty()) {
            result += queue.poll();
        }
        System.out.println(result);
    }
}

class Lecture implements Comparable<Lecture> {
    int deadline;
    int pay;

    public Lecture(int deadline, int pay) {
        this.deadline = deadline;
        this.pay = pay;
    }

    public int compareTo(Lecture o) {
        if(o.deadline == this.deadline) {
            return o.pay - this.pay;
        } else {
            return this.deadline - o.deadline;
        }
    }
}
