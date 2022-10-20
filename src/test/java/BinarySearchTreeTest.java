import org.fantasticGroup.BinarySearchTree;
import org.fantasticGroup.BinarySearchTreeNode;
import org.fantasticGroup.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTreeTest {
    BinarySearchTree bst;
    @Before
    public void setUp(){
        bst=new BinarySearchTree();
    }
    @Test
    public void insertIntoEmpty(){

        Assert.assertTrue(bst.insert(4));
        Assert.assertTrue(bst.insert(5));
        Assert.assertTrue(bst.insert(8));
        Assert.assertEquals(3,bst.size());
    }
    @Test
    public void insertDuplicate(){

        bst.insert(4);
        bst.insert(5);
        bst.insert(8);
        Assert.assertFalse(bst.insert(4));
    }
    @Test
    public void containsTrue(){

        bst.insert(20.0);
        bst.insert(30.5);
        bst.insert(25.98);
        Assert.assertTrue(bst.contains(20.0));
    }
    @Test
    public void containsFalse(){

        bst.insert('a');
        bst.insert('b');
        bst.insert('c');
        Assert.assertFalse(bst.contains('d'));
    }
    @Test
    public void findMinReturnsMinimum(){
        bst.insert(20.0);
        bst.insert(30.5);
        bst.insert(25.98);
        bst.insert(87.4);
        bst.insert(2.3);
        bst.insert(0.5);
        bst.insert(27.6);
        Assert.assertEquals(0.5,bst.findMin());
    }
    @Test
    public void findMinEmptyTree(){
        Assert.assertEquals(null,bst.findMin());
    }
    @Test
    public void rebalance(){
        BinarySearchTreeNode<Integer> node1=new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node2=new BinarySearchTreeNode<>(1);
        BinarySearchTreeNode<Integer> node3=new BinarySearchTreeNode<>(10);
        BinarySearchTreeNode<Integer> node4=new BinarySearchTreeNode<>(20);
        BinarySearchTreeNode<Integer> node5=new BinarySearchTreeNode<>(35);
        node1.setLeftChild(node2);
        node1.setRightChild(node3);
        node3.setRightChild(node4);
        node4.setRightChild(node5);
        bst.setRoot(node1);
        bst.rebalance();
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(20,5,1,10,35));
        Assert.assertEquals(bst.preOrder(),arrayList);
    }
}
