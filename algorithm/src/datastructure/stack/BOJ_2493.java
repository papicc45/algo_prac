package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();
        for(int i=0 ; i<n ; i++) {
            stack.push(new Tower(i+1, Integer.parseInt(st.nextToken())));
        }
        int[] result = new int[n+1];
        Stack<Tower> remainStack = new Stack<>();
        while(stack.size() != 1) {
            Tower tower = stack.pop();

            Tower next = stack.peek();
            if(next.height > tower.height) {
                while(!remainStack.isEmpty() && remainStack.peek().height < next.height) {
                    Tower remain = remainStack.pop();
                    result[remain.index] = next.index;
                }
                result[tower.index] = next.index;
            } else {
                remainStack.push(tower);
            }
        }
        result[1] = 0;

        for(int i=1 ; i<=n ; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

class Tower {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
