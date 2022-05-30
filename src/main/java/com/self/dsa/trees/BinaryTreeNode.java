package com.self.dsa.trees;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode() {
    }

    BinaryTreeNode(T val) {
        this.data = val;
    }

    BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}
