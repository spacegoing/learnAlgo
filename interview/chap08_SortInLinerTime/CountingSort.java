package chap08_SortInLinerTime;

import java.util.Arrays;

/**
 * 记数排序 p108
 *
 * @author xiuzhu
 * 151201
 */
public class CountingSort {


    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        int[] a3 = {2, 5, 3, 9, 2, 3, 0, 3};    //illegal input: 9
        System.out.println("result: " + Arrays.toString(cs.sort(a3, 10)));
        int[] a2 = {6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2};    //legal
        System.out.println("result: " + Arrays.toString(cs.sort(a2, 7)));
    }

    public int[] sort(int a[], int k) {
        int[] c = new int[k];

        //step1: make c[i] contains numbers of elements
        // equals to i's n occurrences in a[].
        for (int anA : a) c[anA]++;

        //step2: update a[] based on c[].
        int ind = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = c[i]; j > 0; j--) {
                a[ind++] = i;
            }
        }

        return a;
    }

}
