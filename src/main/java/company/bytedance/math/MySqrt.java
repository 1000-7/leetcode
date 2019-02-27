package company.bytedance.math;

public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int min = 1, max = x;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                max = mid - 1;
            } else if (x / mid > mid){
                min = mid + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(8));
    }
}