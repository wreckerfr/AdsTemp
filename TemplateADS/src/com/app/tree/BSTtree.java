package com.app.tree;

import java.util.LinkedList;
import java.util.Queue;



public class BSTtree {
	private TreeNode root;

	// Nested TreeNode class
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	// Constructor
	public BSTtree() {
	        this.root = null;
	    }

	// Method to add a new node to the BST
	public void insert(int val) {
		root = insertRecursive(root, val);
	}

	private TreeNode insertRecursive(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		if (val < root.val) {
			root.left = insertRecursive(root.left, val);
		} else if (val > root.val) {
			root.right = insertRecursive(root.right, val);
		}

		return root;
	}

	// Method to delete a node from the BST
	public void delete(int val) {
		root = deleteRecursive(root, val);
	}

	private TreeNode deleteRecursive(TreeNode root, int val) {
		if (root == null) {
			return null;
		}

		if (val < root.val) {
			root.left = deleteRecursive(root.left, val);
		} else if (val > root.val) {
			root.right = deleteRecursive(root.right, val);
		} else {
			// Case 1: Node to be deleted has no children or only one child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// Case 2: Node to be deleted has two children
			root.val = findMinValue(root.right);
			root.right = deleteRecursive(root.right, root.val);
		}

		return root;
	}

	// Helper method to find the minimum value in the subtree
	private int findMinValue(TreeNode node) {
		int minValue = node.val;
		while (node.left != null) {
			minValue = node.left.val;
			node = node.left;
		}
		return minValue;
	}

	// Method to search for a node in the BST
	public boolean search(int val) {
		return searchRecursive(root, val);
	}

	private boolean searchRecursive(TreeNode root, int val) {
		if (root == null) {
			return false;
		}

		if (val == root.val) {
			return true;
		} else if (val < root.val) {
			return searchRecursive(root.left, val);
		} else {
			return searchRecursive(root.right, val);
		}
	}

	// Method to get the maximum value in the BST
	public int getMaxValue() {
		if (root == null) {
			throw new IllegalStateException("Tree is empty, no maximum value.");
		}

		TreeNode current = root;
		while (current.right != null) {
			current = current.right;
		}
		return current.val;
	}

	// Method to get the minimum value in the BST
	public int getMinValue() {
		if (root == null) {
			throw new IllegalStateException("Tree is empty, no minimum value.");
		}

		TreeNode current = root;
		while (current.left != null) {
			current = current.left;
		}
		return current.val;
	}

	// Method to get the height of the tree
	public int getHeight() {
		return calculateHeight(root);
	}

	private int calculateHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = calculateHeight(root.left);
		int rightHeight = calculateHeight(root.right);

		return 1 + Math.max(leftHeight, rightHeight);
	}

	// Method to get the depth of a node in the tree
	public int getDepth(int val) {
		return calculateDepth(root, val, 0);
	}

	private int calculateDepth(TreeNode root, int val, int depth) {
		if (root == null) {
			return -1; // Node not found
		}

		if (val == root.val) {
			return depth;
		} else if (val < root.val) {
			return calculateDepth(root.left, val, depth + 1);
		} else {
			return calculateDepth(root.right, val, depth + 1);
		}
	}

	// Method to replace all left nodes with right nodes and vice versa
	public void swapLeftAndRight() {
		swapLeftAndRightRecursive(root);
	}

	private void swapLeftAndRightRecursive(TreeNode root) {
		if (root == null) {
			return;
		}

		// Swap left and right subtrees
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		// Recursively swap for left and right children
		swapLeftAndRightRecursive(root.left);
		swapLeftAndRightRecursive(root.right);
	}

	// Method for pre-order traversal of the tree
	public void preOrderTraversal() {
		preOrderRecursive(root);
		System.out.println();
	}

	private void preOrderRecursive(TreeNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}

	// Method for in-order traversal of the tree
	public void inOrderTraversal() {
		inOrderRecursive(root);
		System.out.println();
	}

	private void inOrderRecursive(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrderRecursive(root.left);
		System.out.print(root.val + " ");
		inOrderRecursive(root.right);
	}

	// Method for post-order traversal of the tree
	public void postOrderTraversal() {
		postOrderRecursive(root);
		System.out.println();
	}

	private void postOrderRecursive(TreeNode root) {
		if (root == null) {
			return;
		}

		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.val + " ");
	}

	// Method for level-order traversal of the tree
	public void levelOrderTraversal() {
	        if (root == null) {
	            return;
	        }

	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);

	        while (!queue.isEmpty()) {
	            TreeNode current = queue.poll();
	            System.out.print(current.val + " ");

	            if (current.left != null) {
	                queue.offer(current.left);
	            }
	            if (current.right != null) {
	                queue.offer(current.right);
	            }
	        }

	        System.out.println();
	    }
}