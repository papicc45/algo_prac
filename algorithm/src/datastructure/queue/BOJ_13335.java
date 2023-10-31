package datastructure.queue;

import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        int temp = 0;
        int time = 0;
        int index = 0;
        while (true) {
            if(index == n)
                break;
            time++;

            if(queue.size() == w) {
                temp = temp - queue.poll();
            } else if(queue.size() < w) {
                if(!queue.isEmpty()) {
                    temp = temp - queue.poll();
                }
                int truck = trucks[index];
                if(temp + truck <= l) {
                    queue.add(truck);
                    index++;
                    temp += truck;
                } else {
                    queue.add(0);
                }
            }

        }

        System.out.println(time);
    }
}
