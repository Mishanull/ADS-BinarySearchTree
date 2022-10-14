package org.fantasticGroup;

public class BinaryTree<E> {
    private BinaryTreeNode<E> root;
    int size;

    public BinaryTree() {
        size = 0;
        root = null;
    }

    public BinaryTree(int size) {
        this.size = size;
    }

    public BinaryTree(BinaryTreeNode<E> root, int size) {
        this.root = root;
        this.size = size;
    }

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


    public boolean contains(BinaryTreeNode<E> current, E e) {
        boolean aux = false;
        if(root==null){
            System.out.println("Empty tree");
            return false;
        }
        else {
            if (e.equals(current.getElement())) {
                aux=true;
            }

            if (current.leftChild != null) {
                aux = contains(current.leftChild, e);
            }
            if (!aux && current.rightChild != null) {
                aux = contains(current.rightChild, e);
            }
        }
        return aux;
    }
}
