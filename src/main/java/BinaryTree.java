import java.util.List;
import java.util.Stack;

public class BinaryTree {

    public static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int x) {
            val = x;
        }
    }

    private BinaryTree() {}

    public static void preOrderRecursively(BinaryTreeNode root) {
        if (root == null) {return;}
        System.out.print(root.val + " ");
        preOrderRecursively(root.left);
        preOrderRecursively(root.right);
    }

    public static void inOrderRecursively(BinaryTreeNode root) {
        if (root == null) {return;}
        inOrderRecursively(root.left);
        System.out.print(root.val + " ");
        inOrderRecursively(root.right);
    }

    public static void postOrderRecursively(BinaryTreeNode root) {
        if (root == null) {return;}
        postOrderRecursively(root.left);
        postOrderRecursively(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrder(BinaryTreeNode root) {
        if (root == null) {return;}
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val + " ");
            // 先压入右节点，再压入左节点
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        System.out.println();
    }

    public static void inOrder(BinaryTreeNode root) {
        if (root == null) {return;}
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 压入左边界
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
                // 如果右子树不为空，会继续将左边界压入栈
            }
        }
        System.out.println();
    }

    public static void postOrderTwoStacks(BinaryTreeNode root) {
        // 先序 中->左->右
        // 先序' 中->右->左（先压入左节点，再压入右节点）
        // 后序 左->右->中（翻转）
        if (root == null) {return;}
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> collect = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            collect.push(root);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        while (!collect.isEmpty()) {
            System.out.print(collect.pop().val + " ");
        }
        System.out.println();
    }

    public static void postOrderOneStack(BinaryTreeNode root) {
        if (root == null) {return;}
        // 如果没有打印过节点，h 就是根节点
        // 否则 h 是上次打印的节点
        BinaryTreeNode h = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(h);
        while (!stack.isEmpty()) {
            BinaryTreeNode cur = stack.peek();
            if (cur.left != null && h != cur.left && h != cur.right) {
                // 有左子树且左子树没处理过
                stack.push(cur.left);
            } else if (cur.right != null && h != cur.right) {
                // 有右子树且右子树没处理过
                stack.push(cur.right);
            } else {
                // 左右子树都没有或都处理过了
                System.out.print(cur.val + " ");
                h = stack.pop();
            }
        }
        System.out.println();
    }

    public static BinaryTreeNode buildPreIn(List<Integer> pre, List<Integer> in) {
        return buildPreIn(pre, 0, pre.size(), in, 0, in.size());
    }

    private static BinaryTreeNode buildPreIn(List<Integer> pre, int start1, int end1,
                                             List<Integer> in, int start2, int end2) {
        if (start1 >= end1) {return null;}
        if (start2 >= end2) {return null;}
        int rootVal = pre.get(start1);
        int rootIdx = in.indexOf(rootVal);
        if (rootIdx < 0) {return null;}
        int leftLen = rootIdx - start2;
        BinaryTreeNode root = new BinaryTreeNode(rootVal);
        root.left = buildPreIn(pre, start1 + 1, start1 + leftLen + 1, in, start2, rootIdx);
        root.right = buildPreIn(pre, start1 + leftLen + 1, end1, in, rootIdx + 1, end2);
        return root;
    }
}
