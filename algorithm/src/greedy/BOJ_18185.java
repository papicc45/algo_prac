package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N+2];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        int ans = 0;
        while (idx < N) {
            //디버그 해보기
            if (A[idx] > 0) {
                int temp = A[idx];
                ans += 3*temp;
                temp = Math.min(temp, A[idx+1]);
                ans += 2*temp;
                A[idx+1] -= temp;
                temp = Math.min(temp, A[idx+2]-Math.min(A[idx+1], A[idx+2]));
                ans += 2*temp;
                A[idx+2] -= temp;
            }
            idx++;
        }
        System.out.println(ans);
    }
}
