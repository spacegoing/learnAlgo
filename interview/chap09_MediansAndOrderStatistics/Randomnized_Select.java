package chap09_MediansAndOrderStatistics;

import java.util.Random;

public class Randomnized_Select {

    public static void main(String[] args) throws Exception {
        Randomnized_Select rs = new Randomnized_Select();
        int[] a = {2, 3, 4, 87, 38, 143, 87, 32, 7};
//		System.out.println(rs.randomnized_select(a, 0, a.length - 1, 0));
        System.out.println(rs.randomnized_select(a, 0, a.length - 1, 1));
        System.out.println(rs.randomnized_select(a, 0, a.length - 1, 5));
        System.out.println(rs.randomnized_select(a, 0, a.length - 1, 9));
//		System.out.println(rs.randomnized_select(a, 0, a.length - 1, 10));
        int[] b = {2};
        System.out.println(rs.randomnized_select(b, 0, b.length - 1, 1));
        System.out.println("-------------------");
    }

    int randomnized_select(int[] a, int left, int right, int i) {
        if (left == right) {
            return a[left];
        }

        int q = rand_partition(a, left, right);
        if (q + 1 == i) {
            return a[q];
        }

        if (q + 1 < i) {
            return randomnized_select(a, q + 1, right, i);
        } else {
            return randomnized_select(a, left, q - 1, i);
        }
    }

    int partition(int[] a, int left, int right) {
        int pivot = a[right];

        int left_end = left - 1;
        for (int i = left; i < right; i++) {
            if (a[i] < pivot) {
                left_end++;
                int tmp = a[left_end];
                a[left_end] = a[i];
                a[i] = tmp;
            }
        }

        int tmp = a[right];
        a[right] = a[left_end + 1];
        a[left_end + 1] = tmp;

        return left_end + 1;
    }

    int rand_partition(int[] a, int left, int right) {
        Random random = new Random();
        int r = left + random.nextInt(right - left + 1);

        int tmp = a[right];
        a[right] = a[r];
        a[r] = tmp;

        return partition(a, left, right);
    }
}
