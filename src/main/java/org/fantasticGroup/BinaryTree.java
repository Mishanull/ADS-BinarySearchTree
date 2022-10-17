package org.fantasticGroup;

public class BinaryTree<E> {
    private BinaryTreeNode<E> root;
    int size;

    public BinaryTree() {
        size = 0;
        root = null;
    }

    public BinaryTree(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public int getSize(BinaryTreeNode<E> current) {

        if (current == null) {
            return 0;
        } else return getSize(current.leftChild) + 1 + getSize(current.rightChild);

    }

    public boolean contains(BinaryTreeNode<E> current, E e) {
        boolean aux = false;
        if (root == null) {
            System.out.println("Empty tree");
            return false;
        }
        if (e.equals(current.getElement())) {
            aux = true;
        }
        if (!aux && current.leftChild != null) {
            aux = contains(current.leftChild, e);
        }
        if (!aux && current.rightChild != null) {
            aux = contains(current.rightChild, e);
        }

        return aux;
    }

    public int depth(BinaryTreeNode<E> current) {
        if (current == null) {
            return 0;
        } else {
            int lDepth = depth(current.leftChild);
            int rDepth = depth(current.rightChild);
            if (lDepth > rDepth) {
                return lDepth + 1;
            } else return rDepth + 1;
        }
    }
}
