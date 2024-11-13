package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1 ; i<=n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[100001];
        long answer = 0;
        int left = 1;
        int right = 0;
        while (left <= n) {

            while (right + 1 <= n && cnt[arr[right + 1]] == 0) {
                right++;
                cnt[arr[right]]++;
            }

            answer += right - left + 1;
            cnt[arr[left++]]--;
        }
    }
}
