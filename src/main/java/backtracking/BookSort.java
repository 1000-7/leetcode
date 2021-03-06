package backtracking;

public class BookSort {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        fullSort(arr, 0, arr.length - 1);
        System.out.println(res);
    }

    static int res = 0;

    static void fullSort(int[] arr, int start, int end) {
        if (start == end) {
            if (check(arr)) res++;
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, start, i);
            fullSort(arr, start + 1, end);
            swap(arr, start, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static boolean check(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == 1) return false;
        }
        return true;
    }
}
