package recursion;

import org.junit.jupiter.params.ParameterizedTest;
import utils.ArrayArgumentsProvider;
import utils.TreeNode;
import utils.TreeNodeBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Symmetric {

    @ParameterizedTest
    @ArrayArgumentsProvider.ArraySources(
            arrays = {
                    @ArrayArgumentsProvider.ArraySource(array = {1,2,2,-1,3,-1,3})
            }
    )
    void test(int[] vals){
        TreeNodeBuilder builder1 = TreeNodeBuilder.getInstance().build(vals);

        symmetricRun2(builder1.node,builder1.node);

    }

    boolean symmetricRun2(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        if(t1 == t2 && t1.left != null) {
            return symmetricRun2(t1.left, t2.right);
        }

        return (t1.val == t2.val)
                && symmetricRun2(t1.left, t2.right)
                && symmetricRun2(t2.left, t1.right);
    }


    boolean symmetricRun(TreeNode root) {

        if(root == null) return true;
//        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
//        List<Integer> leftVal = new LinkedList<>();
//        List<Integer> rightVal = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();
            List<Integer> vals = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if(curr != null) {
                    vals.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }
                else {
                    vals.add(null);
                }
            }
            if(!isLevelSymmetric(vals)) {
                return false;
            }
        }


        return true;
    }

    private boolean isLevelSymmetric(List<Integer> currentLevel){
        int start = 0;
        int end = currentLevel.size() - 1;
        while(start < end){
            if(currentLevel.get(start) != currentLevel.get(end))
                return false;
            ++start;
            --end;
        }
        return true;
    }
}
