package com.self.dsa.binarysearchtrees;

class Remove {
    int minimum;
    BinaryTreeNode<Integer> removed;
    BinaryTreeNode<Integer> right;
}

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;


    public void insert(int data) {
        root = insert(root, data);
    }

    private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int data) {
        if (node == null) {
            return new BinaryTreeNode<>(data);
        }
        if (data <= node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void remove(int data) {

        root = remove(root, data);
    }

    private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> node, int data) {
        if (node == null)
            return null;

        if (node.data == data) {
            node = removeNode(node);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            node.right = remove(node.right, data);
        }
        return node;
    }

    private BinaryTreeNode<Integer> removeNode(BinaryTreeNode<Integer> node) {

        if (node.left != null && node.right != null) {
            Remove remove = removeMin(node.right);
            node.right = remove.removed;
            node.data = remove.minimum;
            return node;
        } else if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            return null;
        }
    }

    private Remove removeMin(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new Remove();
        }
        if (node.left == null && node.right == null) {
            Remove remove = new Remove();
            remove.minimum = node.data;
            remove.removed = null;
            return remove;
        }
        Remove remove = removeMin(node.left);
        node.left = remove.removed;
        remove.removed = node;
        return remove;
    }

    public void printTree() {
        print(root);
    }

    private void print(BinaryTreeNode<Integer> node) {
        if (node == null)
            return;
        String left = node.left != null ? "L:" + node.left.data + "," : "";
        String right = node.right != null ? "R:" + node.right.data : "";
        String output = node.data + ":" + left + right;

        System.out.println(output);

        print(node.left);
        print(node.right);
    }

    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(BinaryTreeNode<Integer> node, int data) {
        if (node == null)
            return false;

        if (data == node.data)
            return true;
        else if (data < node.data)
            return search(node.left, data);
        else
            return search(node.right, data);
    }


}