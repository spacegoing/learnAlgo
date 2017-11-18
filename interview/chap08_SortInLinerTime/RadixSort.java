package chap08_SortInLinerTime;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {923, 56, 789, 329, 5, 1};

        RadixSort radixSort = new RadixSort();
        int[] res = radixSort.sort(arr, 3);
        System.out.println(Arrays.toString(res));
    }

    static int getDigit(int value, int digitPlace) {
        return ((value / digitPlace) % 10);
    }

    /**
     * @param a   input array
     * @param nod number of digids
     * @return
     */
    // Sort the numbers beginning with least-significant digit
    int[] sort(int[] a, int nod) {
        int place = 1;
        int[] res = a;

        // Largest place for a 32-bit int is the 1 billion's place
        for (int i = 0; i < nod; i++) {
            // Use counting sort at each digit's place
            res = countingSort(res, place);
            place *= 10;
        }

        return res;
    }

    int[] countingSort(int[] arr, int nod) {
        int[] c = new int[10];
        for (int a : arr)
            c[getDigit(a, nod)]++;

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        int[] b = new int[arr.length];

        // !!! i from length-1 down to 0 !!!
        for (int i = arr.length - 1; i >= 0; i--) {
            int d = getDigit(arr[i], nod);
            b[c[d] - 1] = arr[i];
            c[d]--;
        }

        return b;
    }
}
