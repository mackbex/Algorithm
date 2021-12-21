package recursion;

import org.junit.Test;
import utils.TreeNode;
import utils.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findDuplicateSubtrees {


    @Test
    public void test() {
        TreeNode node = TreeNodeBuilder.getInstance().build(
                new Integer[]{1,2,3,4,null,2,4,null,null,4}
        ).node;

        List<TreeNode> res = findDuplicateSubtrees(node);

    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> set = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper(root, res, set);
        return res;
    }
    public String helper(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if(root == null) return "";
        String s = "("+helper(root.left, res, map) + root.val + helper(root.right, res, map)+")";
        if(map.getOrDefault(s,0) == 1) res.add(root);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}
