package chap02_GettingStarted;

import java.util.Arrays;

public class Text2_3_MergeSort {

    public static void main(String[] args) {
        Text2_3_MergeSort t = new Text2_3_MergeSort();

        int e[] = {8, 7, 2, 5, 9, 8, 5};
        t.mergeSort(e, 0, e.length - 1);
        System.out.println(Arrays.toString(e));

        int a[] = {8, 7, 2, 5, 9, 8};
        t.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        int b[] = {8, 7};
        t.mergeSort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));

        int c[] = {8};
        t.mergeSort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));

        int f[] = {8, 7, 2, 10, 100, 99, 80, 98};
        t.mergeSort(f, 0, f.length - 1);
        System.out.println(Arrays.toString(f));
    }


    void mergeSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left < mid) {
            mergeSort(arr, left, mid);
        }
        if (mid + 1 < right) {
            mergeSort(arr, mid + 1, right);
        }

        merge(arr, left, mid, right);
    }

    void merge(int[] arr, int left, int mid, int right) {
        int i = 0, j = 0;

        int[] left_arr = new int[mid - left + 2];
        System.arraycopy(arr, left, left_arr, 0, mid - left + 1);
        left_arr[left_arr.length - 1] = Integer.MAX_VALUE;

        int[] right_arr = new int[right - mid + 1];
        System.arraycopy(arr, mid + 1, right_arr, 0, right - mid);
        right_arr[right_arr.length - 1] = Integer.MAX_VALUE;

        for (int k = left; k <= right; k++) {
            if (left_arr[i] <= right_arr[j]) {
                arr[k] = left_arr[i++];
            } else {
                arr[k] = right_arr[j++];
            }
        }

    }

}
