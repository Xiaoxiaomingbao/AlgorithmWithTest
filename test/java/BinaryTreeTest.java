import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeTest {
    @Test
    public void show() {
        BinaryTree.BinaryTreeNode root = new BinaryTree.BinaryTreeNode(1);
        root.left = new BinaryTree.BinaryTreeNode(2);
        root.right = new BinaryTree.BinaryTreeNode(3);
        root.left.left = new BinaryTree.BinaryTreeNode(4);
        root.left.right = new BinaryTree.BinaryTreeNode(5);
        root.right.left = new BinaryTree.BinaryTreeNode(6);
        root.right.right = new BinaryTree.BinaryTreeNode(7);

        System.out.println("先序遍历");
        BinaryTree.preOrderRecursively(root);
        System.out.println();
        BinaryTree.preOrder(root);

        System.out.println("中序遍历");
        BinaryTree.inOrderRecursively(root);
        System.out.println();
        BinaryTree.inOrder(root);

        System.out.println("后序遍历");
        BinaryTree.postOrderRecursively(root);
        System.out.println();
        BinaryTree.postOrderTwoStacks(root);
        BinaryTree.postOrderOneStack(root);
    }

    @Test
    public void showBuild() {
        List<Integer> pre = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> in = Arrays.asList(3, 2, 4, 1, 6, 5, 7);
        BinaryTree.BinaryTreeNode root = BinaryTree.buildPreIn(pre, in);

        System.out.println("先序遍历");
        BinaryTree.preOrderRecursively(root);
        System.out.println();

        System.out.println("中序遍历");
        BinaryTree.inOrderRecursively(root);
        System.out.println();
    }
}
