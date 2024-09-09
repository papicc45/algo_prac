package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_22866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] near = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(near, -100_000);
        int[] cnt = new int[n+1];
        Stack<Integer> stack = new Stack<>();

        for(int i=1 ; i<=n ; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            cnt[i] = stack.size();
            if(cnt[i] > 0)
                near[i] = stack.peek();

            stack.push(i);
        }

        stack = new Stack<>();
        for(int i=n; i>0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            int s = stack.size();
            cnt[i] += s;
            if(s > 0 && stack.peek()-i < i-near[i]) near[i] = stack.peek();
            stack.push(i);
        }


        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<=n ; i++) {
            sb.append(cnt[i]);
            if(cnt[i] > 0) {
                sb.append(" ").append(near[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
