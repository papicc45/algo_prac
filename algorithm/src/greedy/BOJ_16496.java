package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++) {
            sb.append(arr[i]);
        }

        boolean check = false;
        String result = sb.toString();
        for(int i=0 ; i<result.length() ; i++) {
            if(result.charAt(i) != '0')
                check = true;
        }
        if(check) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}
