package graph.dijkstra;

import java.net.NetworkInterface;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] answer = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(temp[0] == k) {
                System.out.println(temp[1]);
                break;
            }
            if(visited[temp[0]])
                continue;

            visited[temp[0]] = true;
            for(int i=0 ; i<3 ; i++) {
                int next;
                int time;
                if(i == 0) {
                    next = temp[0] * 2;
                    time = temp[1];
                } else if(i == 1) {
                    next = temp[0] - 1;
                    time = temp[1] + 1;
                } else {
                    next = temp[0] + 1;
                    time = temp[1] + 1;
                }

                if(next>=0 && next <= 100000) {
                    if(!visited[next]) {
                        queue.add(new int[] {next, time});
                    }
                }
            }
        }
    }
}
