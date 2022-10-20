package org.fantasticGroup;

public class BinaryTreeNode<E> {
     E element;
     BinaryTreeNode<E> rightChild;
     BinaryTreeNode<E> leftChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(E element) {
        this.element = element;
        leftChild=null;
        rightChild=null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public String toString() {
        if(element==null) return "no element";
        return element.toString()+" ";
    }
}
