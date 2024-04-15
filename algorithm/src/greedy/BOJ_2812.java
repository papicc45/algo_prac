package greedy;

import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.*;

public class BOJ_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        String[] str = br.readLine().split("");
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int index = 0;
        int count = 0;
        stack.push(arr[index++]);
        while (index < n) {
            if(count == k)
                break;

            if(stack.peek() < arr[index]) {
                while (!stack.isEmpty() && stack.peek() < arr[index] && count < k) {
                    stack.pop();
                    count++;
                }
                stack.push(arr[index]);
            } else {
                stack.push(arr[index]);
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        if(count == k) {
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            for(int i=index ; i<n ; i++) {
                sb.append(str[i]);
            }
        } else {
            while (count != k) {
                stack.pop();
                count++;
            }
            for(int i=0 ; i<n-k ; i++) {
                sb.insert(0, stack.pop());
            }
        }
        System.out.println(sb.toString());

    }
}
