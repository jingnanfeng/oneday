package com.nanfeng.one.three;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-03-21 21:45
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        ListNode listNode = new ListNode(0);

        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0)
            listNode.next = new ListNode(carry);

        return listNode.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }


    private String[] aas;

    public String[] getAas() {
        return aas;
    }


    public void setAas(String[] aas) {
        this.aas = aas;
    }
}
