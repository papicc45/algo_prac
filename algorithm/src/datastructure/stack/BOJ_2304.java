package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sticks = new int[1001];

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            sticks[idx] = h;
            left = Math.min(left, idx);
            right = Math.max(right, idx);
        }

        Stack<Integer> stack = new Stack<>();

        int h = sticks[left];
        for(int i=left+1 ; i<=right ; i++) {
            if(h > sticks[i])
                stack.push(i);
            else {
                while (!stack.isEmpty()) {
                    int idx = stack.pop();
                    sticks[idx] = h;
                }
                h = sticks[i];
            }
        }

        h = sticks[right];
        stack.clear();
        for(int i=right-1 ; i>=left ; i--) {
            if(h > sticks[i])
                stack.push(i);
            else {
                while (!stack.isEmpty()) {
                    int idx = stack.pop();
                    sticks[idx] = h;
                }
                h = sticks[i];
            }
        }

        int result = 0;
        for(int i=left ; i<=right ; i++) {
            result += sticks[i];
        }
        System.out.println(result);
    }
}
