package sort.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1517 {
    static int[] originArr;
    static long result = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        originArr = new int[n];
        for(int i=0 ; i<n ; i++) {
            originArr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n-1);
        System.out.println(result);

    }
    public static void mergeSort(int start ,int end) {
        if(start >= end)
            return;
        int mid = (start + end) >> 1;

        mergeSort(start, mid);
        mergeSort(mid+1, end);

        int[] leftArr = Arrays.copyOfRange(originArr, start, mid+1);
        int[] rightArr = Arrays.copyOfRange(originArr, mid+1, end+1);
        int index = start;
        int leftIndex = 0;
        int rightIndex = 0;
        int count = leftArr.length;
        while(leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if(leftArr[leftIndex] > rightArr[rightIndex]) {
                originArr[index] = rightArr[rightIndex++];
                result += count;
            } else {
                originArr[index] = leftArr[leftIndex++];
                count--;
            }
            index++;
        }
        while(rightIndex < rightArr.length) {
            originArr[index++] = rightArr[rightIndex++];
        }
        while(leftIndex < leftArr.length) {
            originArr[index++] = leftArr[leftIndex++];
        }
    }
}
