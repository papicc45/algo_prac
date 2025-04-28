package sort.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        heapSort(arr);
    }
    private static void mergeSort(int[] arr) {
        if(arr.length < 2)
            return;

        mergeSort(arr, 0, arr.length - 1);
    }
    private static void mergeSort(int[] arr, int left, int right) {
        if(left >= right)  return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right) {
            tmp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while(i <= mid) {
            tmp[k++] = arr[i++];
        }
        while(j <= right) {
            tmp[k++] = arr[j++];
        }
        System.arraycopy(tmp , 0, arr, left, tmp.length);
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 1) Max‑heap 만들기
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        // 2) 루트를 끝으로 보내며 힙 크기 줄이기
        for (int end = n - 1; end > 0; end--) {
            swap(arr, 0, end);          // 최대값을 배열 뒤로
            heapify(arr, end, 0);       // 남은 구간 다시 힙화
        }
    }
    private static void heapify(int[] arr, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        if (left < size && arr[left] > arr[largest]) largest = left;
        if (right < size && arr[right] > arr[largest]) largest = right;
        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, size, largest);
        }
    }

    /* ---------- 공용 swap ---------- */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
