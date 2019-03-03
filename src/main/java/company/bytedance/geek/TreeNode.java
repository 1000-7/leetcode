package company.bytedance.geek;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
    
    public static TreeNode init() {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(8);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn10 = new TreeNode(10);
        TreeNode tn11 = new TreeNode(11);
        TreeNode tn12 = new TreeNode(12);
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;
        tn3.right = tn7;
        tn4.left = tn8;
        tn4.right = tn9;
        tn5.left = tn10;
        tn5.right = tn11;
        tn6.left = tn12;
        
        return tn1;
    }
}