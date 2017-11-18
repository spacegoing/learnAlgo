package chap07_QuickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int a[], int start, int end) {
        int mid = rand_partition(a, start, end);
        if (mid > start + 1)
            sort(a, start, mid - 1);
        if (mid + 1 < end)
            sort(a, mid + 1, end);
    }

    int partition(int[] a, int left, int right) {
        int pivot = a[right];

        int left_end = left - 1;
        for (int i = left; i < right; i++) {
            if (a[i] <= pivot) {
                left_end++;
                int tmp = a[i];
                a[i] = a[left_end];
                a[left_end] = tmp;
            }
        }

        int tmp = a[right];
        a[right] = a[left_end + 1];
        a[left_end + 1] = tmp;

        return left_end + 1;
    }

    int rand_partition(int[] a, int left, int right) {
        Random r = new Random();
        int i = left + r.nextInt(right - left + 1);

        int tmp = a[i];
        a[i] = a[right];
        a[right] = tmp;

        return partition(a, left, right);
    }
}
