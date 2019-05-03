package Tree;

import java.util.ArrayList;
import java.util.List;

public class BST {

    private TreeNode root;

    public void insert(int data) {
        if (this.root == null) {
            this.root = new TreeNode(data);
            return;
        }

        TreeNode node = this.root;
        while (node != null) {
            if (data > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(data);
                    return;
                }
                node = node.right;
            } else { // data <= node.val
                if (node.left == null) {
                    node.left = new TreeNode(data);
                    return;
                }
                node = node.left;
            }
        }
    }

    public void delete(int data) {
        TreeNode node = this.root;
        TreeNode father = null; // Record node's father

        while (node != null && node.val != data) {
            father = node;
            node = data > node.val ? node.right : node.left;
        }
        // Target not exist
        if (node == null) return;

        // Case 1: node has 2 child
        if (node.left != null && node.right != null) {
            // Find the min node in right tree
            TreeNode minNode   = node.right;
            TreeNode minFather = node;
            while (minNode.left != null) {
                minFather = minNode;
                minNode   = minNode.left;
            }
            node.val = minNode.val;
            // Delete min node later
            node     = minNode;
            father   = minFather;
        }

        // Case 2: node has 1 child or node is leaf
        TreeNode child = node.left != null ? node.left : node.right;

        if (father == null)
            this.root = child; // Delete root
        else if (father.left == node)
            father.left = child;
        else
            father.right = child;
    }

    public TreeNode find(TreeNode node) {
        return find(node.val);
    }

    public TreeNode find(int data) {
        TreeNode node = this.root;

        while (node != null) {
            if (data < node.val)
                node = node.left;
            else if (data > node.val)
                node = node.right;
            else
                return node;
        }
        // Not exist
        return null;
    }

    public TreeNode findFather(TreeNode node) {
        return findFather(node.val);
    }

    public TreeNode findFather(int data) {
        if (this.root == null) return null;

        TreeNode node = this.root;
        TreeNode father = null;

        while (node != null) {
            if (node.val == data)
                return father;

            father = node;
            if (data < node.val) {
                node = node.left;
            } else {// data > node.val
                node = node.right;
            }
        }
        // Not exist
        return null;
    }

    public TreeNode findMin() {
        return findMin(this.root);
    }

    public TreeNode findMin(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode findMax() {
        return findMax(this.root);
    }

    public TreeNode findMax(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Pred & Succ in BST (inorder)
    public TreeNode findPredNode(TreeNode target) {
        TreeNode node = find(target);
        
        if (node.left != null) return findMax(node.left);

        TreeNode father = findFather(node);
        while (father != null && node == father.left) {
            node   = father;
            father = findFather(node);
        }
        
        return father;
    }

    public TreeNode findSuccNode(TreeNode root, TreeNode target) {
        TreeNode node = find(target);
        
        if (node.right != null) return findMin(node);

        TreeNode father = findFather(node);
        while (father != null && node == father.right) {
            node   = father;
            father = findFather(node);
        }
        
        return father;
    }

    public List<Integer> toList(TreeNode root) {
        ArrayList<Integer> valList = new ArrayList<>();
        TraverseAlgo.inorder(root, valList);
        return valList;
    }

}
