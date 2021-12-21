package tree;

import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Traverse {

    @Test
    public void test() {

        TreeNode node = TreeNodeBuilder
                .getInstance().build(new Integer[]{
                        1,2,3,4,5,6,7
                }).node;

//        List<Integer> res = new ArrayList<>();

        int res = postorderExercise(node);
        System.out.println("A");
    }

    TreeNode inorder(TreeNode node, List<Integer> res) {
        if(node == null) return null;

        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);

        return node;
    }

    TreeNode preorder(TreeNode node, List<Integer> res) {
        if(node == null) return null;

        res.add(node.val);
        preorder(node.left,res);
        preorder(node.right,res);

        return node;
    }

    TreeNode postorder(TreeNode node, List<Integer> res) {
        if(node == null) return null;

        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);

        return node;
    }

    int postorderExercise(TreeNode node) {
        if(node == null) return 0;

        int ln = postorderExercise(node.left);
        int rn = postorderExercise(node.right);

        return node.val + Math.min(ln,rn);
    }



}
