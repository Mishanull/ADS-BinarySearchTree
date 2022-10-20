import org.fantasticGroup.BinaryTree;
import org.fantasticGroup.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class BinaryTreeTests {
    BinaryTree binaryTree;
    BinaryTree<Integer> binaryTreeTest;
    @Before
    public void setUp(){
        binaryTree=new BinaryTree<>();
        binaryTreeTest = new BinaryTree<>();
        int a = 25;
        int b = 15;
        int c = 50;
        int d = 10;
        int e = 22;
        int f = 35;
        int g = 70;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node3.setElement(c);
        node4.setElement(d);
        node5.setElement(e);
        node6.setElement(f);
        node7.setElement(g);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node3.setLeftChild(node6);
        node3.setRightChild(node7);
        binaryTreeTest.setRoot(node);
    }
    @Test
    public void sizeIfEmpty(){
        Assert.assertEquals(0, binaryTree.size());
        Assert.assertTrue(binaryTree.isEmpty());
    }
    @Test
    public void sizeAfterAddingOneElement(){
        int i=1;
        BinaryTreeNode<Integer> node=new BinaryTreeNode<>(i);
        binaryTree.setRoot(node);
        Assert.assertEquals(1,binaryTree.size());
    }

    @Test
    public void sizeAfterAddingMultiplesElement(){
        int a=12;
        int b=23;
        int c=76;
        int d=87;
        BinaryTreeNode<Integer> node=new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node2=new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node3=new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node4=new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node3.setElement(c);
        node4.setElement(d);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        node3.setLeftChild(node4);
        binaryTree.setRoot(node);
        Assert.assertEquals(4,binaryTree.size());
    }
    @Test
    public void getRootCorrect(){
        int i=1;
        int b='a';
        int c=12;
        BinaryTreeNode<Integer> node=new BinaryTreeNode<>(i);
        BinaryTreeNode<Integer> node2=new BinaryTreeNode<>(b);
        BinaryTreeNode<Integer> node3=new BinaryTreeNode<>(c);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        binaryTree.setRoot(node);

        Assert.assertEquals(binaryTree.getRoot(), node);
    }
    @Test
    public void setElementInNodeCorrect(){
        char b='a';
        BinaryTreeNode<Character> node=new BinaryTreeNode<>();
        node.setElement(b);
        Assert.assertEquals('a', node.getElement().charValue());
    }

    @Test
    public void getElementInNodeCorrect() {
        int a = 12;
        int b = 23;
        int c = 76;
        int d = 87;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node3.setElement(c);
        node4.setElement(d);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        node3.setLeftChild(node4);
        binaryTree.setRoot(node);
        Assert.assertEquals(76, node3.getElement(),0);
    }

    @Test
    public void addLeftChildCorrect(){
        double a=12.5;
        double b=23.1;
        BinaryTreeNode<Double> node=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node2=new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node.setLeftChild(node2);
        Assert.assertEquals(node2, node.getLeftChild());
        Assert.assertEquals(23.1, node.getLeftChild().getElement(),0);
    }

    @Test
    public void addRightChildCorrect() {
        int a = 12;
        int b = 23;
        int c = 76;
        int d = 87;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node3.setElement(c);
        node4.setElement(d);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        node3.setLeftChild(node4);
        binaryTree.setRoot(node);
        Assert.assertEquals(node3, node.getRightChild());
        Assert.assertEquals(76, node.getRightChild().getElement(),0);
    }

    @Test
    public void setRootCorrect() {
        int a = 12;
        int b = 23;
        int c = 76;
        int d = 87;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>();
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node3.setElement(c);
        node4.setElement(d);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        node3.setLeftChild(node4);
        binaryTree.setRoot(node);
        Assert.assertEquals(node, binaryTree.getRoot());
        Assert.assertEquals(12, ((int) binaryTree.getRoot().getElement()),0);
    }

    @Test
    public void containsReturnsTrue(){
        double a=12.5;
        double b=23.1;
        double c=76.23;
        double d=87.6;
        BinaryTreeNode<Double> node=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node2=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node3=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node4=new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node3.setElement(c);
        node4.setElement(d);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        node3.setLeftChild(node4);
        binaryTree.setRoot(node);
        Assert.assertTrue(binaryTree.contains(d));
    }
    @Test
    public void containsReturnsFalse(){
        double a=12.5;
        double b=23.1;
        double c=76.23;
        double d=87.6;
        double e=90.8;
        BinaryTreeNode<Double> node=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node2=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node3=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node4=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node5=new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node3.setElement(c);
        node4.setElement(d);
        node5.setElement(e);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        node3.setLeftChild(node4);
        binaryTree.setRoot(node);
        Assert.assertFalse(binaryTree.contains(e));
    }

    @Test
    public void preOrderCorrect(){
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(25, 15, 10, 22, 50, 35, 70));
        ArrayList<Integer> tree = binaryTreeTest.preOrder();
        Assert.assertEquals(inOrder, tree);
    }

    @Test
    public void inOrderCorrect(){
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(10, 15, 22, 25, 35, 50, 70));
        ArrayList<Integer> tree = binaryTreeTest.inOrder();
        Assert.assertEquals(inOrder, tree);
    }

    @Test
    public void postOrderCorrect(){
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(10, 22, 15, 35, 70, 50, 25));
        ArrayList<Integer> tree = binaryTreeTest.postOrder();
        Assert.assertEquals(inOrder, tree);
    }

    @Test
    public void levelOrderCorrect(){
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(25, 15, 50, 10, 22, 35, 70));
        ArrayList<Integer> tree = binaryTreeTest.levelOrder();
        Assert.assertEquals(inOrder, tree);
    }

    @Test
    public void heightCorrect(){
        Assert.assertEquals(2, binaryTreeTest.height());
    }

    @Test
    public void returnsHeightCorrect(){
        double a=12.5;
        double b=23.1;
        double c=76.23;
        double d=87.6;
        double e=90.8;
        BinaryTreeNode<Double> node=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node2=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node3=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node4=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node5=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node6=new BinaryTreeNode<>(20.4);
        BinaryTreeNode<Double> node7=new BinaryTreeNode<>(12.7);
        node.setElement(a);
        node2.setElement(b);
        node3.setElement(c);
        node4.setElement(d);
        node5.setElement(e);
        node.setLeftChild(node2);
        node.setRightChild(node3);
        node3.setLeftChild(node4);
        node4.setLeftChild(node5);
//        node4.setRightChild(node6);
//        node6.setRightChild(node7);
        binaryTree.setRoot(node);
        Assert.assertEquals(4,binaryTree.depth(binaryTree.getRoot()));
    }
}
