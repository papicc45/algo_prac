package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> dice = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            dice.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(dice);

        boolean nt = true;
        int h = 0;
        int result = 0;
        while (dice.size() != 0) {
            boolean check = true;
            for(int i=0 ; i<dice.size() ; i++) {
                if(dice.get(i) >= h) {
                    if(nt) {
                       result++;
                    }

                    dice.remove(i);
                    h++;
                    nt = false;
                    check = false;
                    break;
                }
            }

            if(check) {
                h = 0;
                nt = true;
            }
        }
        System.out.println(result);
    }
}
