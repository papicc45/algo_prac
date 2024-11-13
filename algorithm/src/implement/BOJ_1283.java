package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1283 {
    static Set set = new HashSet();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++) {
            String[] split = arr[i].split(" ");
            boolean check = false;
            String sum = "";
            for(int j=0 ; j<split.length ; j++) {
                if(check) {
                    sum += split[j] + " ";
                    continue;
                }
                String upper = split[j].substring(0, 1).toUpperCase();
                if(!set.contains(upper)) {
                    check = true;
                    set.add(upper);
                    sum += "[" + split[j].substring(0, 1) + "]" + split[j].substring(1, split[j].length());
                } else {
                    sum += split[j];
                }
                sum += " ";
            }
            if(!check) {
                sum = "";
                for(int j=0 ; j<arr[i].length() ; j++) {
                    String str = arr[i].substring(j, j+1);
                    if(str.equals(" ")) {
                        sum += " ";
                    } else {
                        if(check) {
                            sum += str;
                            continue;
                        }
                        if(!set.contains(str.toUpperCase())) {
                            check = true;
                            set.add(str.toUpperCase());
                            sum += "[" + str + "]";
                        } else {
                            sum += str;
                        }
                    }
                }
            }
            sb.append(sum);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
