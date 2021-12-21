package stack;


import com.sun.source.tree.Tree;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ArrayArgumentsProvider;
import utils.TreeNode;
import utils.TreeNodeBuilder;

import java.util.*;
import java.util.stream.Stream;

public class BinaryTreeOrders {


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        postOrder(root, res);

        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ans = new ArrayList();
        if (root == null) return ans;
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode tree = s.peek();
            if (tree.left != null) {
                s.add(tree.left);
                tree.left = null;
            } else if (tree.right != null) {
                s.add(tree.right);
                tree.right = null;
            } else {
                ans.add(tree.val);
                s.pop();
            }
        }
        return ans;
    }


    @ParameterizedTest
    @ArrayArgumentsProvider.ArraySources(
            arrays = {
                    @ArrayArgumentsProvider.ArraySource(array = {1,2,3,4,-1,-1,5})
            }
    )
    public void test(int[] vals) {
        TreeNodeBuilder builder1 = TreeNodeBuilder.getInstance().build(vals);
        TreeNodeBuilder builder2 = TreeNodeBuilder.getInstance().build(vals);
        TreeNodeBuilder builder3 = TreeNodeBuilder.getInstance().build(vals);
        TreeNode a = builder1.node;
        TreeNode b = builder2.node;
        TreeNode c = builder3.node;
        builder1.node = null;

        TreeNode d= builder1.node;
        TreeNode e= builder2.node;
        TreeNode f= builder3.node;

        TreeNodeBuilder builder4 = TreeNodeBuilder.getInstance();
        TreeNode g = builder2.node;

//        levelOrderTraversal(builder.getNode());
    }

    void levelOrderTraversal(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> vals = new LinkedList<>();
            int size = q.size();
            while(size-- > 0) {
                TreeNode curr = q.poll();
                vals.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }

            res.add(vals);
        }

    }


    void postOrder(TreeNode node, List<Integer> res) {

        if(node == null) return;
        postOrder(node.left, res);
        postOrder(node.right, res);
        res.add(node.val);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);

        return res;
    }

    public void preorder(TreeNode node, List<Integer> list) {
        if(node == null) return;

        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


}
