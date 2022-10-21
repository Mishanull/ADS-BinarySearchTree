package org.fantasticGroup;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>{
    BinarySearchTreeNode<E> root;
    public BinarySearchTree() {
        root=null;
    }

    public BinarySearchTree(BinarySearchTreeNode<E> root) {
        super(root);
    }

    @Override
    public BinarySearchTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinarySearchTreeNode<E> root) {
        this.root=root;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return getSize(root);
    }
    private int getSize(BinarySearchTreeNode<E> current) {
        if(current==null){
            return 0;
        }
        else return getSize(current.leftChild)+1+getSize(current.rightChild);

    }
    @Override
    public boolean contains(E e) {
        return contains(e, root);
    }

    private boolean contains(E e, BinarySearchTreeNode<E> current) {
        if(current==null){
            return false;
        }
        if(current.getElement().compareTo(e)==0){
            return true;
        }
        else if(current.getElement().compareTo(e)<0){
            return contains(e,current.getRightChild());
        }
        else if(current.getElement().compareTo(e)>0){
            return contains(e,current.getLeftChild());
        }
        return false;
    }

    @Override
    public ArrayList<E> inOrder() {
        ArrayList<E> elements=new ArrayList<>();

        return super.inOrder(elements,root);
    }
    @Override
    public ArrayList<E> preOrder() {
        ArrayList<E> elements=new ArrayList<>();
        return super.preOrder(elements,root);
    }

    @Override
    public ArrayList<E> postOrder() {
        return super.postOrder();
    }

    @Override
    public ArrayList<E> levelOrder() {
        return super.levelOrder();
    }

    @Override
    public int height() {
        return super.height();
    }

    @Override
    public int depth(BinaryTreeNode<E> current) {
        return super.depth(current);
    }

    public BinarySearchTreeNode<E> insert(E element, BinarySearchTreeNode<E> current) {
        if(current==null){
            current=new BinarySearchTreeNode<>(element);
            return current;
        }
            if(element.compareTo(current.getElement())>0)
                current.rightChild=insert(element,current.rightChild);
            else
                if(element.compareTo(current.getElement())<0)
                    current.leftChild=insert(element,current.leftChild);
        return current;
    }

    public boolean insert(E element){
        if(this.contains(element)) return false;
        root=insert(element,root);
        return true;
    }

    public E findMin(BinarySearchTreeNode<E> current) {
        if(current==null){
            return null;
        }
        if(current.leftChild==null){
            return current.getElement();
        }
        return findMin(current.getLeftChild());
    }
    public E findMin(){
        return findMin(root);
    }

    //Method to convert tree to a right linked list or "vine" or right tilted tree
    private int treeToVine(BinarySearchTreeNode<E> current){
        int i=0;
        BinarySearchTreeNode<E> aux=current.rightChild;

        while(aux!=null){
            if(aux.leftChild!=null){
                BinarySearchTreeNode<E> aux2=aux;
                aux=aux.leftChild;
                aux2.leftChild=aux.rightChild;
                aux.rightChild=aux2;
                current.rightChild=aux;
            }
            else{
                i++;
                current=aux;
                aux=aux.rightChild;
            }
        }
        return i;
    }
    //method to left rotate each node on the vine
    private void compressVine(BinarySearchTreeNode<E> current, int m){
        BinarySearchTreeNode<E> aux=current.rightChild;

        for(int i=0;i<m;i++){
            BinarySearchTreeNode<E> aux2=aux;
            aux=aux.rightChild;
            current.rightChild=aux;
            aux2.rightChild=aux.leftChild;
            aux.leftChild=aux2;
            current=aux;
            aux=aux.rightChild;
        }
    }
    //Implementing DSW Algorithm to rebalance the tree
    //After this operation, the tree will be a complete balanced binary tree
    protected BinarySearchTreeNode<E> rebalance(BinarySearchTreeNode<E> current){
        BinarySearchTreeNode<E> aux=new BinarySearchTreeNode<>();
        aux.rightChild=current;
        int i=treeToVine(aux);
        int height=(int)(Math.log(i+1)/Math.log(2));
        int noOfNodes=(int)Math.pow(2, height)-1;
        compressVine(aux,i-noOfNodes);
        for(noOfNodes=noOfNodes/2; noOfNodes>0; noOfNodes/=2){
            compressVine(aux,noOfNodes);
        }
        return aux.rightChild;
    }

    public void rebalance(){
        root=rebalance(root);
    }

}
