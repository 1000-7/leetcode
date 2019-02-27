package company.bytedance.array;

import java.util.Arrays;

/**
 * 已知有n个人和m个好友关系（存在数字r），如果两个人是直接或者间接的好友（好友的好友的好友……），则认为他们属于同一个朋友圈。请写程序求出这n个人里一共有多少个朋友圈？
 * 例如：n=5，m=3，r={{1,2}，{2,3}，{4,5}}，表示有5个人，1和2是好友，2和3是好友，4和5是好友，则1、2、3属于一个朋友圈，4、5属于一个朋友圈。最终结果就是2个朋友圈
 */
public class FindCircleNum2 {
    public static void main(String[] args) {
        System.out.println(new FindCircleNum2().friends(7, new int[][]{{4, 6}, {1, 2}, {2, 3}, {4, 5}, {6, 7}}));
    }

    public int friends(int m, int[][] relations) {
        int[] find = new int[m + 1];
        for (int i = 0; i < find.length; i++) {
            find[i] = i;
        }
        Arrays.sort(relations, (o1, o2) -> {
            int nu = o1[0] - o2[0];
            if (nu == 0) {
                return o1[1] - o2[1];
            }
            return nu;
        });

        for (int[] r : relations) {

            int find1 = findFriends(find, r[0]);
            int find2 = findFriends(find, r[1]);
            if (find2 != find1) {
                find[find2] = find1;
                m--;
            }
        }
        return m;
    }

    public int findFriends(int[] find, int i) {
        if (find[i] != i) {
            find[i] = findFriends(find, find[i]);
        }
        return find[i];
    }
}
