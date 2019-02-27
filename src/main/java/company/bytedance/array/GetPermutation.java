package company.bytedance.array;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {
    List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(4, 9));
        System.out.println(new GetPermutation().getPermutation2(4, 9));
        System.out.println(new GetPermutation().getPermutation3(4, 9));
    }

    /**
     * @param n
     * @param k
     * @return 获得所有的全排列按顺序存起来，然后找到第k-1个即第k个
     */
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        permute(arr, 0, n);
        return strings.get(k - 1);
    }

    public void permute(int[] arr, int i, int n) {
        if (i == n - 1) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num);
            }
            strings.add(sb.toString());
        }
        for (int j = i; j < n; j++) {
            swap(arr, i, j);
            int[] temp = arr.clone();
            permute(temp, i + 1, n);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String getPermutation2(int n, int k) {
        int[] fact = new int[n + 1];
        List<Integer> resList = new ArrayList<>();
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            resList.add(i);
            fact[i] = fact[i - 1] * i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(resList.get(index));
            resList.remove(index);
        }
        return sb.toString();
    }

    public String getPermutation3(int n, int k) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(res.get(index));
            res.remove(index);
        }
        return sb.toString();
    }

}