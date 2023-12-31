package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Ramen> ramens = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ramens.add(new Ramen(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(ramens);

        for(Ramen ramen : ramens) {
            int size = queue.size();

            if(size < ramen.deadline) {
                queue.add(ramen.cnt);
            } else if(size == ramen.deadline) {
                int temp = queue.peek();

                if(temp < ramen.cnt) {
                    queue.poll();
                    queue.add(ramen.cnt);
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

class Ramen implements Comparable<Ramen> {
    int deadline;
    int cnt;

    public Ramen(int deadline, int cnt) {
        this.deadline = deadline;
        this.cnt = cnt;
    }

    public int compareTo(Ramen o) {
        if(o.deadline == this.deadline) {
            return o.cnt - this.cnt;
        } else {
            return this.deadline - o.deadline;
        }
    }
}
