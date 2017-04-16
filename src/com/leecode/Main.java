package com.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Honsen on 2016/10/12.
 *
 */
public class Main {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null;
        result = new ListNode(1);
        return result;
    }
}
class ListNode{
    private int value;
    private ListNode next;
    ListNode(int n){value=n;next=null;}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
