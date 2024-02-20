package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16953 {
    static long b;
    static long result = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);

        DFS(a, 0);
        if(result == Long.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(result + 1);

    }
    private static void DFS(long num, long count) {
        if(num == b) {
            result = Math.min(count, result);
            return;
        }

        if(num * 2 <= b) {
            DFS(num * 2, count + 1);
        }

        if(num * 10 + 1 <= b) {
            DFS(num * 10 + 1, count + 1);
        }
    }
}
