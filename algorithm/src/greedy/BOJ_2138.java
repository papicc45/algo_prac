package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138 {
    static boolean[] toggleFirst, notToggleFirst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] now = makeSwitch(n, br.readLine());
        boolean[] goal = makeSwitch(n, br.readLine());

        toggleFirst = new boolean[n];
        notToggleFirst = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            toggleFirst[i] = now[i];
            notToggleFirst[i] = now[i];
        }
        toggleFirst[0] = !toggleFirst[0];
        toggleFirst[1] = !toggleFirst[1];

        int answer1 = 1;
        int answer2 = 0;
        for(int i=1 ; i<n ; i++) {
            if(toggleFirst[i-1] != goal[i-1]) {
                answer1++;
                first(n, i);
            }

            if(notToggleFirst[i-1] != goal[i-1]) {
                answer2++;
                notFirst(n, i);
            }
        }

        boolean check1 = true;
        boolean check2 = true;

        for(int i=0 ; i<n ; i++) {
            if(toggleFirst[i] != goal[i]) {
                check1 = false;
            }
            if(notToggleFirst[i] != goal[i]) {
                check2 = false;
            }
        }

        if(check1 && check2) {
            System.out.println(Math.min(answer1, answer2));
        } else {
            if(check1 && !check2) {
                System.out.println(answer1);
            } else if(!check1 && check2) {
                System.out.println(answer2);
            } else {
                System.out.println(-1);
            }
        }
    }

    static void first(int n, int i) {
        toggleFirst[i-1] = !toggleFirst[i-1];
        toggleFirst[i] = !toggleFirst[i];
        if(i != n-1) {
            toggleFirst[i+1] = !toggleFirst[i+1];
        }
    }
    static void notFirst(int n, int i) {
        notToggleFirst[i-1] = !notToggleFirst[i-1];
        notToggleFirst[i] = !notToggleFirst[i];
        if(i != n-1) {
            notToggleFirst[i+1] = !notToggleFirst[i+1];
        }
    }

    static boolean[] makeSwitch(int n, String str) {
        boolean[] arr = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            if(str.substring(i, i+1).equals("0")) {
                arr[i] = false;
            } else {
                arr[i] = true;
            }
        }
        return arr;
    }
}
