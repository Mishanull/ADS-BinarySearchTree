package org.fantasticGroup;

public class BinarySearchTreeNode<E extends Comparable<E>> extends BinaryTreeNode<E> implements Comparable<E>{

    BinarySearchTreeNode<E> rightChild;
    BinarySearchTreeNode<E> leftChild;
    public BinarySearchTreeNode() {
    }

    public BinarySearchTreeNode(E element) {
        super(element);
    }
    @Override
    public E getElement() {
        return super.getElement();
    }

    @Override
    public void setElement(E element) {
        super.setElement(element);
    }

    @Override
    public BinarySearchTreeNode<E> getRightChild() {
        return rightChild;
    }


    public void setRightChild(BinarySearchTreeNode<E> rightChild) {
        this.rightChild=rightChild;
    }

    @Override
    public BinarySearchTreeNode<E> getLeftChild() {
        return leftChild;
    }


    public void setLeftChild(BinarySearchTreeNode<E> leftChild) {
       this.leftChild=leftChild;
    }

    @Override
    public String toString() {
        return super.toString();
    }



    @Override
    public int compareTo(E o) {
        return super.getElement().compareTo(o);
    }
}
