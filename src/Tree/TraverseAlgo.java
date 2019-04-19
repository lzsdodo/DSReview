package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TraverseAlgo {

    // Recursion
    public static void preorder(TreeNode root) {
        if (root != null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void preorder(TreeNode root, ArrayList<Integer> result) {
        if (root != null) return;

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static void inorder(TreeNode root) {
        if (root != null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root != null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void postorder(TreeNode root) {
        if (root != null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void postorder(TreeNode root, ArrayList<Integer> result) {
        if (root != null) return;

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }


    // BFS
    public static void traverseLevel(TreeNode root) {
        if (root != null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // Set<TreeNode> visited = new HashSet<>();
        // visited.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            System.out.println("Level: " + level);

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                // if (!visited.contains(node)) { visited.add(node); ... }
                if (node.left  != null) queue.offer(node);
                if (node.right != null) queue.offer(node);
            }

            level++;
        }
    }

    // Find prev node in Binary Tree
    public static TreeNode findFather(TreeNode root, TreeNode father, int data) {
        if (root == null) return null;

        if (root.val == data) return father;
        TreeNode left = findFather(root.left, root, data);
        TreeNode right = findFather(root.right, root, data);

        if (left  != null) return left;
        if (right != null) return right;

        return null;
    }

}
