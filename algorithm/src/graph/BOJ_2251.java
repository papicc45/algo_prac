package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2251 {
    static int[] send = {0, 0, 1, 1, 2, 2};
    static int[] receive = {1, 2, 0, 2, 0, 1};

    static boolean[][] visited = new boolean[201][201];
    static boolean[] answer = new boolean[201];
    static int[] now = new int[3];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        BFS();
        for(int i=0 ; i<answer.length ; i++) {
            if(answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int a = temp[0];
            int b = temp[1];
            int c = now[2] - a - b;

            for(int i=0 ; i<6 ; i++) {
                int[] next = {a, b, c};
                next[receive[i]] += next[send[i]];
                next[send[i]] = 0;

                if(next[receive[i]] > now[receive[i]]) {
                    next[send[i]] = next[receive[i]] - now[receive[i]];
                    next[receive[i]] = now[receive[i]];
                }
                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new int[] {next[0], next[1]});
                    if(next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}
