package org.fantasticGroup;

public class BinaryTree<E> {
    private BinaryTreeNode<E> root;
    int size;

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
