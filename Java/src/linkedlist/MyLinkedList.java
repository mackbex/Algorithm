package linkedlist;

import org.junit.Test;
import utils.ListNode;

class LinkedList {

    int length;
    Node head;
    class Node {
        int val;
        Node next;
        Node(int x) {
            this.val = x;
        }
    }

    /** Initialize your data structure here. */
    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if(head == null) return -1;
        if(index >= length) return -1;

        Node cur = head;
        int pos = 0;
        while(pos != index) {
            cur = cur.next;
            pos ++;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        length++;
        if(head == null) {
            head = new Node(val);
            return;
        }
        Node tail = head;
        head = new Node(val);
        head.next = tail;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
            head = new Node(val);
            length++;
            return;
        }

        Node cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val);
        length++;

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index == length) {
            addAtTail(val);
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index > length) {
            return;
        }

        int pos = 0;
        Node temp = head;
        Node next = new Node(val);
        while(pos != (index-1)) {
            temp = temp.next;
            pos ++;
        }
        next.next = temp.next;
        temp.next =  next;
        length ++ ;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(head == null) return;
        if(index > length - 1) return;
        if(index == 0) {
            head = head.next;
            length --;
            return;
        }

        Node prev = null;
        Node cur = head;
        int pos = 0;
        while(pos != index) {
            prev = cur;
            cur = cur.next;
            pos++;
        }
        prev.next = cur.next;
        length --;

    }


}

public class MyLinkedList {
    @Test
    public void test() {
        LinkedList linked = new LinkedList();
        linked.addAtHead(4);
        linked.get(1);
        linked.addAtHead(1);
        linked.addAtHead(5);
        linked.deleteAtIndex(3);
        linked.addAtHead(7);
        linked.get(3);
        linked.get(3);
        linked.get(3);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */