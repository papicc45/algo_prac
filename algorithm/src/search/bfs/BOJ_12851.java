package search.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12851 {
    static int n, k;
    static boolean[][] visited;

    static int[] min;
    static int[] count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[100001][3];
        min = new int[100001];
        count = new int[100001];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[n] = 1;
        // 0  = -1
        // 1 = 1
        // 2 = *2
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if(temp < 0 || temp > 100000)
                continue;

            int plus = temp + 1;
            if(plus >= 0 && plus <= 100000 && !visited[plus][1]) {
                if(min[plus] > min[temp] + 1) {
                    min[plus] = min[temp] + 1;
                    if(count[temp] == 0) {
                        count[plus] = 1;
                    } else {
                        count[plus] = count[temp];
                    }
                } else if(min[plus] == min[temp] + 1) {
                    count[plus] += count[temp];
                }
                visited[plus][1] = true;
                queue.add(plus);
            }

            int minus = temp - 1;
            if(minus >= 0 && minus <= 100000 && !visited[minus][0]) {
                if(min[minus] > min[temp] + 1) {
                    min[minus] = min[temp] + 1;
                    if(count[temp] == 0) {
                        count[minus] = 1;
                    } else {
                        count[minus] = count[temp];
                    }
                } else if(min[minus] == min[temp] + 1) {
                    count[minus] += count[temp];
                }
                visited[minus][0] = true;
                queue.add(minus);
            }

            int mul = temp * 2;
            if(mul >= 0 && mul <= 100000 && !visited[mul][2]) {
                if(min[mul] > min[temp] + 1) {
                    min[mul] = min[temp] + 1;
                    if(count[temp] == 0) {
                        count[mul] = 1;
                    } else {
                        count[mul] = count[temp];
                    }
                } else if(min[mul] == min[temp] + 1) {
                    count[mul] += count[temp];
                }
                visited[mul][2] = true;
                queue.add(mul);
            }
        }
        System.out.println(min[k]);
        System.out.println(count[k]);
    }
}

