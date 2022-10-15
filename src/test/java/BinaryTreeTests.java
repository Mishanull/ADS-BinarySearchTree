import org.fantasticGroup.BinaryTree;
import org.fantasticGroup.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.model.TestClass;

@RunWith(JUnit4.class)
public class BinaryTreeTests {
    BinaryTree binaryTree;
    @Before
    public void setUp(){
        binaryTree=new BinaryTree<>();
    }
    @Test
    public void sizeIfEmpty(){
        Assert.assertEquals(0, binaryTree.getSize(binaryTree.getRoot()));
    }
    @Test
    public void sizeAfterAddingOneElement(){
        int i=1;
        BinaryTreeNode<Integer> node=new BinaryTreeNode<>(i);
        binaryTree.setRoot(node);
        Assert.assertEquals(1,binaryTree.getSize(binaryTree.getRoot()));
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
    public void addLeftChildCorrect(){
        double a=12.5;
        double b=23.1;
        BinaryTreeNode<Double> node=new BinaryTreeNode<>();
        BinaryTreeNode<Double> node2=new BinaryTreeNode<>();
        node.setElement(a);
        node2.setElement(b);
        node.setLeftChild(node2);
        Assert.assertEquals(node2, node.getLeftChild());
        Assert.assertEquals(23.1, node.getLeftChild().getElement(),0.0);
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
        Assert.assertTrue(binaryTree.contains(binaryTree.getRoot(),d));
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
        System.out.println(binaryTree.getSize(binaryTree.getRoot()));
        Assert.assertFalse(binaryTree.contains(binaryTree.getRoot(),e));
    }
}
