package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafpaths {
    List<String> allPaths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return allPaths;
        dfsHelper(root, "");
        return allPaths;
    }

    private void dfsHelper(TreeNode root, String path) {
        // Base case when we are at leaf Node
        if (root != null && root.left == null && root.right == null) {
            allPaths.add(path + root.val);
        }
        if (root.left != null) {
            dfsHelper(root.left, path + root.val + "->");

        }
        if (root.right != null) {
            dfsHelper(root.right, path + root.val + "->");

        }

    }
}
