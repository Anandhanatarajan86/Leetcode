package binarytrees;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public class InorderTraversal {
        List<Integer> inorderList = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfsHelper(root);
            return inorderList;
        }

        private void dfsHelper(TreeNode root) {
            // Base case
            if (root == null) {
                return;
            }
            dfsHelper(root.left);
            // add myself to inorder list before proceeding right
            if (root != null) {
                inorderList.add(root.val);
            }
            dfsHelper(root.right);

        }

    }
}
