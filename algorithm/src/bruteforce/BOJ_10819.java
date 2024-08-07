package bruteforce;

import java.util.Scanner;

public class BOJ_10819 {
    static int n;
    static int[] arr;
    static int[] cal;
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        cal = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        recur(0);
        System.out.println(result);
    }
    private static void recur(int cnt) {
        if(cnt == n) {
            int sum = 0;
            for(int i=0 ; i<n-1 ; i++) {
                sum += Math.abs(cal[i] - cal[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                cal[cnt] = arr[i];
                recur(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
