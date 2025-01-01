package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_22556 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack[] stacks = new Stack[4];
        for(int i=0 ; i<4 ; i++) {
            stacks[i] = new Stack<Integer>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean result = true;
        for(int i=0 ; i<n ; i++) {
            int num = arr[i];
            boolean check = false;
            for(int j=0 ; j<4 ; j++) {
                if(stacks[j].isEmpty()) {
                    stacks[j].push(num);
                    check = true;
                    break;
                } else {
                    if((int)stacks[j].peek() < num) {
                        stacks[j].push(num);
                        check = true;
                        break;
                    }
                }
            }
            if(!check) {
                result = false;
                break;
            }
        }
        System.out.println(result ? "YES" : "NO");
    }
}
