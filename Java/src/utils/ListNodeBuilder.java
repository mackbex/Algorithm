package utils;

import java.util.LinkedList;
import java.util.Queue;


public class ListNodeBuilder {

    private ListNodeBuilder() {}

    private static class InnerInstanceClazz {
        private static final ListNodeBuilder instance = new ListNodeBuilder();
    }

    public static ListNodeBuilder getInstance() {
        return InnerInstanceClazz.instance;
    }

    public ListNode node;

    public ListNodeBuilder build(Integer[] vals) {
        Integer[] a = vals;

        ListNode root = new ListNode(a[0]);
//        build(root, a, 1);

        ListNode head = root;
        int i = 1;
        while(i < vals.length) {
            head.next = new ListNode(a[i]);
            head = head.next;
            i++;
        }

        node = root;
        return InnerInstanceClazz.instance;
    }

    public ListNodeBuilder build(int[] vals) {
        Integer[] a = new Integer[vals.length];
        for(int i = 0; i < vals.length; i++) {
            a[i] = vals[i] != -1 ? vals[i] : null;
        }

        ListNode root = new ListNode(a[0]);
        build(root, a, 1);



        node = root;
        return InnerInstanceClazz.instance;
    }

    void build(ListNode node, Integer[] val, int index) {
        if(index >= val.length) return;

        node.next = new ListNode(val[index++]);
        build(node.next, val, index);

    }


}
