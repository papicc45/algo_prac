package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_31719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0 ; i<n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int s = 1;
            ArrayList<Integer>[] stack = new ArrayList[2];
            stack[0] = new ArrayList<>();
            stack[1] = new ArrayList<>();

            for(int i=0 ; i<n ; i++) {


                if(arr[i] == s) {
                    s++;
                    continue;
                }

                for(int j=0 ; j<2 ; j++) {
                    if(stack[j].size() == 0) {
                        stack[j].add(arr[i]);
                        break;
                    } else {
                        if(stack[j].get(0) + 1 == arr[i]) {
                            stack[j].add(arr[i]);
                            break;
                        } else if(s == stack[j].get(0)) {
                            s = stack[j].get(stack[j].size() - 1) + 1;
                            stack[j].clear();
                        }
                    }
                }
            }
            if(stack[0].size() != 0 && stack[0].get(0) == s) {
                s = stack[0].get(stack[0].size() - 1) + 1;
                stack[0].clear();

                if(stack[1].size() != 0 && stack[1].get(0) == s) {
                    s = stack[1].get(stack[1].size() - 1) + 1;
                    stack[1].clear();
                }
            } else if(stack[1].size() != 0 && stack[1].get(0) == s) {
                s = stack[1].get(stack[1].size() - 1) + 1;
                stack[1].clear();

                if(stack[0].size() != 0 && stack[0].get(0) == s) {
                    s = stack[0].get(stack[0].size() - 1) + 1;
                    stack[0].clear();
                }
            }
            if(s == n+1 && stack[0].size() == 0 && stack[1].size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            t--;
        }
    }
}
