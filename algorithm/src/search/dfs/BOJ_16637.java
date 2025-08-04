package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637 {
    static int[] nums;
    static char[] ops;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n/2 + 1];
        ops = new char[n/2];

        String str = br.readLine();
        int numIdx = 0;
        for(int i = 0; i < n; i+=2){
            nums[numIdx++] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        int opsIdx = 0;
        for(int i=1 ; i<n-1 ; i+=2) {
            ops[opsIdx++] = str.charAt(i);
        }

        dfs(0, nums[0]);
        System.out.println(result);
    }

    private static void dfs(int depth, int sum) {
        if(depth == ops.length) {
            result = Math.max(result, sum);
            return;
        }

        //괄호 없이 다음 숫자
        int next = calc(sum, ops[depth], nums[depth + 1]);
        dfs(depth + 1, next);

        //괄호 묶기
        if(depth + 1 < ops.length) {
            int group = calc(nums[depth + 1], ops[depth + 1], nums[depth+2]);
            next = calc(sum, ops[depth], group);
            dfs(depth + 2, next);
        }
    }
    private static int calc(int a, char op, int b) {
        int cal = 0;
        if(op == '+') {
            cal = a + b;
        } else if(op == '-') {
            cal = a - b;
        } else if(op == '*') {
            cal = a * b;
        }

        return cal;
    }
}
