package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_19940 {
    static boolean[] visited;
    static Time[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[61];
        arr = new Time[61];
        int t = sc.nextInt();

        bfs();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();

            int quo = n / 60;
            int rem = n % 60;
            sb.append(quo + arr[rem].addh).append(" ")
                    .append(arr[rem].addt).append(" ")
                    .append(arr[rem].mint).append(" ")
                    .append(arr[rem].addo).append(" ")
                    .append(arr[rem].mino).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void bfs() {
        Time time = new Time(0, 0, 0, 0, 0, 0);
        Queue<Time> queue = new LinkedList<>();
        queue.add(time);

        while (!queue.isEmpty()) {
            Time temp = queue.poll();

            if(temp.t >= 0 && temp.t <= 60 && !visited[temp.t]) {
                visited[temp.t] = true;
                arr[temp.t] = temp;

                queue.add(new Time(temp.t - 1, temp.addh, temp.addt, temp.addo, temp.mint, temp.mino + 1));
                queue.add(new Time(temp.t + 1, temp.addh, temp.addt, temp.addo + 1, temp.mint, temp.mino));
                queue.add(new Time(temp.t - 10, temp.addh, temp.addt, temp.addo, temp.mint + 1, temp.mino));
                queue.add(new Time(temp.t + 10, temp.addh, temp.addt + 1, temp.addo, temp.mint, temp.mino));
                queue.add(new Time(temp.t + 60, temp.addh + 1, temp.addt, temp.addo, temp.mint, temp.mino));
            }
        }
    }
    static class Time {
        int t, addh, addt, mint, addo, mino;

        public Time(int t, int addh, int addt, int addo, int mint, int mino) {
            this.t = t;
            this.addh = addh;
            this.addt = addt;
            this.mint = mint;
            this.addo = addo;
            this.mino = mino;
        }
    }
}
