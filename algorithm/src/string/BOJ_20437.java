package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int k=0 ; k<n ; k++) {
            String str = br.readLine();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i=0 ; i<26 ; i++) {
                list.add(new ArrayList<>());
            }

            for(int i=0 ; i<str.length() ; i++) {
                char ch = str.charAt(i);
                list.get(ch - 'a').add(i);
            }

            int  x = Integer.parseInt(br.readLine());

            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;
            for(int i=0 ; i<list.size() ; i++) {
                ArrayList<Integer> temp = list.get(i);
                for(int j=0 ; j+x-1 < temp.size() ; j++) {
                    int s = temp.get(j);
                    int e = temp.get(j+x-1);
                    minLength = Math.min(minLength, e-s+1);
                    maxLength = Math.max(maxLength, e-s+1);
                }
            }
            if(minLength == Integer.MAX_VALUE && maxLength == Integer.MIN_VALUE)
                System.out.println(-1);
            else
                System.out.println(minLength + " " + maxLength);
        }
    }
}
