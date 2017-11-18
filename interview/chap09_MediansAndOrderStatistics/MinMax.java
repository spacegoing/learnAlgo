package chap09_MediansAndOrderStatistics;

import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        int[] test = {1};

        int[] res;
        MinMax minMax = new MinMax();
        res=minMax.min_max(test);
        System.out.println(Arrays.toString(res));
    }

    int[] min_max(int[] a) {
        int min, max;
        int left;
        if (a.length % 2 == 0) {
            if (a[0] <= a[1]) {
                min = a[0];
                max = a[1];
            } else {
                min = a[1];
                max = a[0];
            }
            left = 2;
        } else {
            min = max = a[0];
            left = 1;
        }

        for (int i = left; i < a.length; i += 2) {
            if (a[i] <= a[i + 1]) {
                if (min >= a[i]) {
                    min = a[i];
                }
                if (max <= a[i + 1]) {
                    max = a[i + 1];
                }
            } else {
                if (min >= a[i + 1]) {
                    min = a[i + 1];
                }
                if (max <= a[i]) {
                    max = a[i];
                }
            }
        }

        int[] amin_max = {0, 0};
        amin_max[0] = min;
        amin_max[1] = max;
        return amin_max;
    }
}
