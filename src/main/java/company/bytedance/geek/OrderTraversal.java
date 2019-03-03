package company.bytedance.geek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderTraversal {
    private List<List<Integer>> dfsList = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println(new OrderTraversal().bfsLevelOrder(TreeNode.init()));
        System.out.println(new OrderTraversal().dfsLevelOrder(TreeNode.init()));
    }
    
    public List<List<Integer>> bfsLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pollFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(list);
        }
        return res;
    }
    
    public List<List<Integer>> dfsLevelOrder(TreeNode root) {
        dfs(root, 0);
        return dfsList;
    }
    
    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= dfsList.size()) {
            dfsList.add(new ArrayList<>());
        }
        dfsList.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
