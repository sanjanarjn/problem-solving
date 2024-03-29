package com.self.dsa.binarytrees;

/**
 * You are given the root of a binary tree. We install cameras on the tree nodes
 * where each camera at a node can monitor its parent, itself, and its immediate children.
 * <p>
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 * @author sanjanarajan
 */
class Detail {
    int minCam;
    boolean isCovered;
    boolean isRootMarked;

    public Detail() {

    }

    public Detail(int minCam, boolean isCovered, boolean isRootMarked) {
        this.minCam = minCam;
        this.isCovered = isCovered;
        this.isRootMarked = isRootMarked;

    }
}

public class BinaryTreeCameras {

    public int minCameraCover(BinaryTreeNode root) {


        Detail detail = minCam(root);
        int minCam = detail.minCam;

        if (!detail.isCovered)
            minCam++;

        return minCam;
    }

    private Detail minCam(BinaryTreeNode node) {

        if (node == null) {
            return new Detail(0, true, false);
        }

        Detail leftD = minCam(node.left);
        Detail rightD = minCam(node.right);

        Detail nodeDetail = new Detail();

        int minCam = leftD.minCam + rightD.minCam;
        boolean isAnyNotCovered = !leftD.isCovered || !rightD.isCovered;
        boolean isAnyRootMarked = leftD.isRootMarked || rightD.isRootMarked;

        if (isAnyNotCovered) {
            minCam++;
            nodeDetail.isCovered = true;
            nodeDetail.isRootMarked = true;
        }
        if (isAnyRootMarked) {
            nodeDetail.isCovered = true;
        }
        nodeDetail.minCam = minCam;
        return nodeDetail;
    }
}