package recursion;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ArrayArgumentsProvider;
import utils.TreeNode;
import utils.TreeNodeBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class TargetSum {

    static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {
                            5,4,8,11,null,13,4,7,2,null,null,null,1
                        },
                        (Object) 22
                        ));
    }

    long start;
    @BeforeEach
    public void start() {
        start = System.currentTimeMillis();
    }

    @AfterEach
    public void end() {
        System.out.println(System.currentTimeMillis() - start);
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(Integer[] a, int target) {


        TreeNode node = TreeNodeBuilder.getInstance().build(a).node;
        List<Integer> sumList = new LinkedList<>();

//        hasPathSum2(node, target);
        hasPathSum1(sumList, node, 0);



        System.out.println("A");
        Assertions.assertEquals(1,1);
    }

    public void hasPathSum1(List<Integer> sumList, TreeNode node, int sum) {

        if(node.left == null && node.right == null) {
            sumList.add(node.val + sum);
        }
        else {
            sum += node.val;
            if(node.left != null) hasPathSum1(sumList, node.left, sum);
            if(node.right != null) hasPathSum1(sumList, node.right, sum);
        }
    }

    public boolean hasPathSum2(TreeNode node, int sum) {

        if(node == null) return false;
        if(node.left == null && node.right == null && sum == node.val) return true;

        boolean left = hasPathSum2(node.left, sum - node.val);
        boolean right = hasPathSum2(node.right, sum - node.val);

        return left || right;
    }

//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if(root == null)  return false;
//
//        if(root.left==null && root.right==null && targetSum-root.val==0) {
//            return true;
//        }else {
//            return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
//        }
//    }
}
