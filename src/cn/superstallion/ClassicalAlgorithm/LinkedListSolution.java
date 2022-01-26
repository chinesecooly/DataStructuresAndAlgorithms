package cn.superstallion.ClassicalAlgorithm;
import java.awt.*;
import java.lang.annotation.Target;
import java.util.*;

/**
 * 链表相关题目
 */
public class LinkedListSolution {

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }else if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    //合并n个有序列表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }else {
            return merge(lists,0,lists.length-1);
        }
    }
    public ListNode merge(ListNode[] lists,int left,int right){
        if (left==right){
            return lists[left];
        }else {
            int mid=left+(right-left)/2;
            ListNode listNode1 = merge(lists, left, mid);
            ListNode listNode2 = merge(lists, mid + 1, right);
            return mergeTwoLists(listNode1,listNode2);
        }
    }

    //反转链表
    public static ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }else {
            ListNode newHead=reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return newHead;
        }
    }

    //反转前n个结点的链表
    public static ListNode end;
    public static ListNode reverseListN(ListNode head,int n){
        if (n==1){
            end=head.next;
            return head;
        }else {
            ListNode newHead=reverseListN(head.next,n-1);
            head.next.next=head;
            head.next=end;
            return newHead;
        }
    }

    //范围链表反转
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==1){
            return reverseListN(head,right);
        }else {
            head.next=reverseBetween(head.next,left-1,right-1);
            return head;
        }
    }

    //两个一组翻转链表
    public static ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead=head.next;
        head.next=swapPairs(newHead.next);
        newHead.next=head;
        return newHead;
    }

    //K个一组翻转链表
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k==1){
            return head;
        }else {
            ListNode right=head;
            for (int i = 1; i < k; i++) {
                if (right==null){
                    return head;
                }
               right=right.next;
            }
            ListNode newHead=reverse(head,right);
            if (right!=null&&right.next!=null){
                head.next=reverseKGroup(head.next,k);
            }
            return newHead;
        }
    }
    public static ListNode reverse(ListNode left,ListNode right){
        if (left==null||right==null||left==right){
            return left;
        } {
            end=right.next;
            ListNode newHead = reverse(left.next, right);
            left.next.next=left;
            left.next=end;
            return newHead;
        }
    }

    //删除链表中与指定结点相同的所有结点
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }else {
            if (head.val==val){
                head=removeElements(head.next,val);
            }else {
                head.next=removeElements(head.next,val);
            }
            return head;
        }
    }

    //删除有序链表中的重复节点
    public static ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode node = findAndDelete(head, set);
        return deleteAll(node, set);
    }
    public static ListNode deleteAll(ListNode head,HashSet<Integer> set){
        if (head==null){
            return null;
        }else if (set.contains(head.val)){
            head=deleteAll(head.next,set);
        }else {
            head.next=deleteAll(head.next,set);
        }
        return head;
    }
    public static ListNode findAndDelete(ListNode head,HashSet<Integer> set){
        if (head==null||head.next==null){
            return head;
        }
        if (head.val== head.next.val){
            set.add(head.val);
            head=findAndDelete(head.next.next,set);
        }else {
            head.next=findAndDelete(head.next,set);
        }
        return head;
    }

    //删除未排序链表重复结点
    public ListNode removeDuplicateNodes(ListNode head) {
        return remove(head, new HashSet<>());
    }
    public ListNode remove(ListNode head,Set<Integer> isExist){
        if (head==null){
            return null;
        }else {
            if (isExist.contains(head.val)){
                head=remove(head.next,isExist);
            }else {
                isExist.add(head.val);
                head.next=remove(head.next,isExist);
            }
            return head;
        }
    }

    //回文链表
    public static ListNode temp;
    public static boolean isPalindrome(ListNode head) {
        if (head!=null){
            if (temp==null){
                temp=head;
            }
            if (!isPalindrome(head.next)){
                return false;
            }else if (head.val!= temp.val){
                return false;
            }else {
                temp=temp.next;
            }
        }
        return true;
    }

    //分隔链表
    public static ListNode partition(ListNode head, int x) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode insertPoint=null;
        ListNode start=null;
        ListNode xNode=null;
        boolean startFlag=false;
        for (ListNode node=head;node!=null;node=node.next){
            if (start!=null&&node.val<x){
                startFlag=true;
            }
            if (!startFlag&&node.val>x){
                start=node;
            }
            if (start==null&&node.val<x){
                insertPoint=node;
            }
            if (node.val==x){
                xNode=node;
                break;
            }
        }
        if (xNode==null&&start==null){
            return head;
        }
        if (start==null){
            start=xNode;
        }
        for (ListNode node=start;node.next!=null;){
            if (node.next.val<x){
                ListNode temp=node.next;
                node.next=node.next.next;
                if (insertPoint==null){
                    temp.next=head;
                    head=temp;
                    insertPoint=head;
                }else {
                    ListNode temp1=insertPoint.next;
                    insertPoint.next=temp;
                    temp.next=temp1;
                    insertPoint=temp;
                }
            }else {
                node=node.next;
            }
        }
        return head;
    }

    //旋转链表
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null){
            return null;
        }
        int step=0;
        ListNode slow=null,fast;
        for (fast=head;;step++){
            if (slow!=null){
                slow=slow.next;
            }
            if (step==k){
                slow=head;
            }
            if (fast.next==null){
                if (step>=k){
                    fast.next=head;
                    break;
                }else {
                    fast=head;
                }
            }else {
                fast=fast.next;
            }
        }
        ListNode next = slow.next;
        slow.next=null;
        return next;
    }

    //插入排序
    static ListNode next;
    static boolean isChange=true;
    public static ListNode insertionSortList(ListNode head) {
        if (isChange){
            next=head.next;
            isChange=false;
        }
        if (next==null){
            return head;
        }else {
            head=sort(head,next,null);
            isChange=false;
            return insertionSortList(head);
        }
    }
    public static ListNode sort(ListNode head,ListNode target,ListNode last){
            if (head.next != target) {
                sort(head.next, target,head);
            }
            if (!isChange){
                next=target.next;
                isChange=true;
            }
            if (head.val> target.val){
                head.next=target.next;
                target.next=head;
                if (last==head||last==null){
                    return target;
                }else {
                    last.next=target;
                    return last;
                }
            }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{4,2,1,3});
        System.out.println(insertionSortList(node));
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int[]ints) {
        this.val=ints[0];
        ListNode node=this;
        for (int i = 1; i < ints.length; i++) {
            node.next=new ListNode(ints[i]);
            node=node.next;
        }
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {
        return  val +  (next==null?"":"," +next);
    }
}