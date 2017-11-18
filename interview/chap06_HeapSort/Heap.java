package chap06_HeapSort;

import java.util.Arrays;

public class Heap {
    int heap_len;

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] arr = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heap.heap_len = arr.length;
        heap.build_max_heap(arr);
        System.out.println(Arrays.toString(arr));
        heap.heap_sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heap.heap_len = arr.length;
        heap.heap_increase_key(arr, 8, 15);
        System.out.println(Arrays.toString(arr));
    }

    static int left(int i) {
        return (i + 1) * 2 - 1;
    }

    static int right(int i) {
        return (i + 1) * 2;
    }

    static int parent(int i) {
        if (i % 2 == 0) {
            return i / 2 - 1;
        } else {
            return (i + 1) / 2 - 1;
        }
    }

    void max_heapify(int[] arr, int i) {
        int l = left(i);
        int r = right(i);

        int max_ind = i;

        if (l < heap_len) {
            if (arr[i] < arr[l]) {
                max_ind = l;
            }
        }

        if (r < heap_len) {
            if (arr[max_ind] < arr[r]) {
                max_ind = r;
            }
        }

        if (max_ind != i) {
            int tmp = arr[i];
            arr[i] = arr[max_ind];
            arr[max_ind] = tmp;
            max_heapify(arr, max_ind);
        }
    }

    void build_max_heap(int[] arr) {
        for (int i = heap_len / 2 - 1; i >= 0; i--) {
            max_heapify(arr, i);
        }
    }

    void heap_sort(int[] arr) {
        build_max_heap(arr);
        heap_len = arr.length;

        while (heap_len > 1) {
            int tmp = arr[0];
            arr[0] = arr[heap_len - 1];
            arr[heap_len - 1] = tmp;
            --heap_len;
            max_heapify(arr, 0);
        }
    }

    int heap_max(int[] heap) {
        return heap[0];
    }

    int heap_extract_max(int[] arr) {
        build_max_heap(arr);
        int max = arr[0];

        arr[0] = arr[heap_len - 1];
        heap_len--;
        max_heapify(arr, 0);

        return max;
    }

    void heap_increase_key(int[] arr, int i, int key) {
        build_max_heap(arr);
        if (key > arr[i]) {
            arr[i] = key;
            while (i > 0 && arr[parent(i)] < arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = tmp;
                i = parent(i);
            }
        }
    }

    int[] heap_insert(int[] arr, int key) {
        build_max_heap(arr);
        heap_len++;
        int[] arr_new = new int[heap_len];
        System.arraycopy(arr, 0, arr_new, 0, arr.length);
        arr_new[heap_len - 1] = Integer.MIN_VALUE;
        heap_increase_key(arr_new, heap_len - 1, key);

        return arr_new;
    }
}
