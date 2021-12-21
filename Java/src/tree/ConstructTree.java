package tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ArrayArgumentsProvider;
import utils.TreeNode;

import java.util.*;
import java.util.stream.Stream;

public class ConstructTree {


    static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of(
                        (Object) new int[]{4, 8, 2, 5, 1, 6, 3, 7},
                        (Object) new int[]{8, 4, 5, 2, 6, 7, 3, 1}
                        )
        );
    }


    HashMap<Integer, Integer> map;
    int cnt;
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(int[] inorder, int[] postorder) {

    }

    public void ip(int[] inorder, int[] postorder) {

        if(inorder.length <= 0 && postorder.length <= 0) return;
        map = new HashMap<>();
        cnt = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }


        TreeNode node = build(0, postorder.length,postorder);

        List<Integer> res = new LinkedList<>();

        preorder(node, res);

        System.out.println("A");
    }



      //(Object) new int[]{9,3,15,20,7},
      //(Object) new int[]{9,15,7,20,3}

    private TreeNode build(int start, int end, int[] postorder) {
        if (start >= end) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[cnt--]);
        int pos = map.get(node.val);
        node.right = build(pos + 1, end, postorder);
        node.left = build(start, pos, postorder);
        return node;
    }

    public void preorder(TreeNode node, List<Integer> res) {
        if(node == null) return;

        res.add(node.val);
        preorder(node.left , res);
        preorder(node.right , res);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int n) {

        Stack<TreeNode> s = new Stack<>();
        HashSet<TreeNode> hs = new HashSet<>();

        int postIdx = n - 1;

        TreeNode root = null;

        for(int p = n - 1, i = n - 1; p >= 0;) {
            TreeNode node = null;

            do {
                node = new TreeNode(postorder[p]);

                if(root == null) {
                    root = node;
                }

                if(s.size() > 0) {
                    if(hs.contains(s.peek())) {
                        hs.remove(s.peek());
                        s.peek().left = node;
                        s.pop();
                    }
                    else {
                        s.peek().right = node;
                    }
                }
                s.push(node);

            }while(postorder[p--] != inorder[i] && p >= 0);

            node = null;

            while(s.size() > 0 && i >= 0 && s.peek().val == inorder[i]) {
                node = s.peek();

                s.pop();
                i--;
            }

            if(node != null) {
                hs.add(node);
                s.push(node);
            }
        }
        return root;
    }
}
