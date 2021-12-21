package utils;

import java.util.LinkedList;
import java.util.Queue;


public class TreeNodeBuilder {

    private TreeNodeBuilder() {}

    private static class InnerInstanceClazz {
        private static final TreeNodeBuilder instance = new TreeNodeBuilder();
    }

    public static TreeNodeBuilder getInstance() {
        return InnerInstanceClazz.instance;
    }

    public TreeNode node;

    public TreeNodeBuilder build(Integer[] vals) {
        Integer[] a = vals;

        TreeNode root = new TreeNode(a[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for(int i = 1; i < a.length; i++) {

            TreeNode node = q.peek();

            if(node.left == null && a[i] != null) {
                node.left = new TreeNode(a[i]);
                q.add(node.left);
            }
            else if(node.right == null) {
                if(node.left == null && a[i] == null) {
                    i++;
                }
                if(a[i] != null) {
                    node.right = new TreeNode(a[i]);
                    q.add(node.right);
                }
                q.remove();
            }
        }
        q.clear();

        node = root;
        return InnerInstanceClazz.instance;
    }

    public TreeNodeBuilder build(int[] vals) {
        Integer[] a = new Integer[vals.length];
        for(int i = 0; i < vals.length; i++) {
            a[i] = vals[i] != -1 ? vals[i] : null;
        }

        TreeNode root = new TreeNode(a[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for(int i = 1; i < a.length; i++) {

            TreeNode node = q.peek();

            if(node.left == null && a[i] != null) {
                node.left = new TreeNode(a[i]);
                q.add(node.left);
            }
            else if(node.right == null) {
                if(node.left == null && a[i] == null) {
                    i++;
                }
                if(a[i] != null) {
                    node.right = new TreeNode(a[i]);
                    q.add(node.right);
                }
                q.remove();
            }
        }
        q.clear();

        node = root;
        return InnerInstanceClazz.instance;
    }


}
