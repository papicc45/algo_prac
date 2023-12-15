package greedy;

import java.util.Scanner;
import java.util.logging.Level;

public class BOJ_10775 {
    static int[] gates;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int g = sc.nextInt();
        int p = sc.nextInt();

        gates = new int[g+1];

        for(int i=1 ; i<=g ; i++) {
            gates[i] = i;
        }
        int result = 0;
        for(int i=0 ; i<p ; i++) {
            int plane = sc.nextInt();

            int gate = find(plane);

            if(gate == 0)
                break;

            result++;
            union(gate, gate-1);
        }

        System.out.println(result);
    }
    public static int find(int a) {
        if(gates[a] == a) {
            return a;
        }
        return gates[a] = find(gates[a]);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            gates[a] = b;
        }
    }
}
