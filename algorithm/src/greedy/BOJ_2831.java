package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> plusM = new ArrayList<>();
        ArrayList<Integer> minusM = new ArrayList<>();
        ArrayList<Integer> plusG = new ArrayList<>();
        ArrayList<Integer> minusG = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            if(h > 0)
                plusM.add(h);
            else
                minusM.add(-1 * h);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            if(h > 0)
                plusG.add(h);
            else
                minusG.add(-1 * h);
        }

        Collections.sort(plusM);
        Collections.sort(minusM);
        Collections.sort(plusG);
        Collections.sort(minusG);

        int i=0 , j = 0;
        int result = 0;
        while (i < minusM.size() && j < plusG.size()) {
            if(minusM.get(i) <= plusG.get(j)) {
                i++;
            } else {
                result++;
                i++;
                j++;
            }
        }
        i = 0;
        j = 0;
        while (i < plusM.size() && j < minusG.size()) {
            if(plusM.get(i) >= minusG.get(j)) {
                j++;
            } else {
                result++;
                i++;
                j++;
            }
        }

        System.out.println(result);
    }
}
