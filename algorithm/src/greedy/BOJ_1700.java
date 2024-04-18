package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[k];
        for(int i=0 ; i<k ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] used = new boolean[k+1];
        int result = 0;
        int count = 0;

        for(int i=0 ; i<k ; i++) {
            int temp = arr[i];
            if(used[temp])
                continue;

            if(count < n) {
                used[temp] = true;
                count++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for(int j=i+1 ; j<k ; j++) {
                    if(used[arr[j]] && !list.contains(arr[j])) {
                        list.add(arr[j]);
                    }
                }
                if(list.size() != n) {
                    for(int j=1 ; j<=k ; j++) {
                        if(used[j] && !list.contains(j)) {
                            used[j] = false;
                            break;
                        }
                    }
                } else {
                    used[list.get(list.size() - 1)] = false;
                }
                used[temp] = true;
                result++;
            }
        }

        System.out.println(result);
    }
}
