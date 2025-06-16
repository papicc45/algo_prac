package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Building> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            if(!stack.isEmpty() && stack.peek().height == height)
                continue;

            if(stack.isEmpty()) {
                if(height != 0)
                    stack.push(new Building(idx, height));
            } else {
                boolean eq = false;
                while (!stack.isEmpty()) {
                    if(stack.peek().height > height) {
                        stack.pop();
                        result++;
                    } else if(stack.peek().height == height){
                        eq = true;
                        break;
                    } else {
                        break;
                    }
                }
                if(!eq && height != 0)
                    stack.push(new Building(idx, height));
            }
        }
        while (!stack.isEmpty()) {
            stack.pop();
            result++;
        }
        System.out.println(result);
    }
    static class Building {
        int idx;
        int height;

        public Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
