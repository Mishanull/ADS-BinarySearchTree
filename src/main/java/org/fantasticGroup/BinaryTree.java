package org.fantasticGroup;

import java.util.ArrayList;

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

    public boolean isEmpty() {
        return root == null || root.getElement() == null;
    }

    public int size() {
        return getSize(root);
    }
    private int getSize(BinaryTreeNode<E> current) {
        if(current==null){
            return 0;
        }
        else return getSize(current.leftChild)+1+getSize(current.rightChild);

    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(BinaryTreeNode<E> current, E e) {
        boolean aux = false;
        if(root==null){
            System.out.println("Empty tree");
            return false;
        }
        if (e.equals(current.getElement())) {
            aux=true;
        }
        if (!aux && current.leftChild != null) {
            aux = contains(current.leftChild, e);
        }
        if (!aux && current.rightChild != null) {
            aux = contains(current.rightChild, e);
        }

        return aux;
    }

    public ArrayList<E> inOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return inOrder(elements, root);
    }

    private ArrayList<E> inOrder(ArrayList<E> list, BinaryTreeNode<E> current) {
        if(current == null) {
            return list;
        }
        inOrder(list,current.getLeftChild());
        list.add(current.getElement());
        inOrder(list,current.getRightChild());
        return list;
    }

    public ArrayList<E> preOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return preOrder(elements, root);
    }

    private ArrayList<E> preOrder(ArrayList<E> list, BinaryTreeNode<E> current) {
        if(current == null) {
            return list;
        }
        list.add(current.getElement());
        preOrder(list,current.getLeftChild());
        preOrder(list,current.getRightChild());
        return list;
    }

    public ArrayList<E> postOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return postOrder(elements, root);
    }

    private ArrayList<E> postOrder(ArrayList<E> list, BinaryTreeNode<E> current) {
        if(current == null) {
            return list;
        }
        postOrder(list,current.getLeftChild());
        postOrder(list,current.getRightChild());
        list.add(current.getElement());
        return list;
    }

    public ArrayList<E> levelOrder() {
        ArrayList<E> list = new ArrayList<>();
        for (int i = 0; i <= height(); i++) {
            levelOrderAddToList(list, root, i);
        }
        return list;
    }

    private void levelOrderAddToList(ArrayList<E> list, BinaryTreeNode<E> current, int level) {
        if (current == null) {
            return;
        }
        if (level == 0) {
            list.add(current.getElement());
        } else {
            levelOrderAddToList(list, current.getLeftChild(), level - 1);
            levelOrderAddToList(list, current.getRightChild(), level - 1);
        }
    }

    public int height() {
        return height(root,0);
    }

    private int height(BinaryTreeNode<E> current, int count) {
        if(current == null)
            return count - 1;
        int leftHeight = height(current.getLeftChild(), count+1);
        int rightHeight = height(current.getRightChild(), count+1) ;

        return Math.max(leftHeight, rightHeight);
    }
}
