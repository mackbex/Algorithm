package recursion;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import utils.ArrayArgumentsProvider;
import utils.TreeNode;
import utils.TreeNodeBuilder;

import java.util.LinkedList;
import java.util.List;

public class MaxDepth {


    @ParameterizedTest
    @ArrayArgumentsProvider.ArraySources(
            arrays = {
                    @ArrayArgumentsProvider.ArraySource(array = {3,9,20,-1,-1,15,7})
            }
    )
    void test(int[] vals) {
        TreeNode root = TreeNodeBuilder.getInstance().build(vals).node;

        bottomUp(root);
    }

    int bottomUp(TreeNode node) {
        if(node == null) return 0;

        int left = bottomUp(node.left);
        int right = bottomUp(node.right);

        return Math.max(left,right) + 1;
    }

    void topDown(TreeNode node, int depth, int ans) {

        if(node == null) return;

        if(node.left == null && node.right == null) {
            ans = Math.max(ans, depth);
        }

        topDown(node.left, depth + 1, ans);
        topDown(node.right, depth + 1, ans);
    }



}
