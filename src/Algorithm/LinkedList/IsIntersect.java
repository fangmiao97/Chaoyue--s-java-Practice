package Algorithm.LinkedList;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/21 15:47
 * @Description：如何判断两个单链表（无环）是否交叉
 */
public class IsIntersect {

    /**
     * @Description: isIntersect
     * @Param:  [a, b]
     * @Return: Algorithm.LinkedList.ListNode
     * @Author: FANG MIAO
     * @Date: 15:52
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static ListNode isIntersect(ListNode a, ListNode b) {
        //先遍历一遍，两个链表的结尾相同，肯定就相交
        //同时记录链表的长度
        ListNode tmpa = a;
        ListNode tmpb = b;
        int aLen = 1;
        int bLen = 1;
        while (tmpa.next != null) {
            tmpa = tmpa.next;
            aLen++;
        }

        while (tmpb.next != null) {
            tmpb= tmpb.next;
            bLen++;
        }

        if (tmpa != tmpb)
            return null;//没有相交

        //相交，找交点。长的那个链先走长出来的部分，
        // 然后两链一起走，相等了就是交点
        if (aLen > bLen) {
            int d = aLen - bLen;
            while (d > 0) {
                a = a.next;
                d--;
            }
        }
        if (bLen > aLen) {
            int d = bLen - aLen;
            while (d > 0) {
                b = b.next;
                d--;
            }
        }

        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        ListNode one1 = new ListNode(1);
        ListNode two1 = new ListNode(2);
        ListNode three1 = new ListNode(3);
        ListNode four1 = new ListNode(4);

        //在5点相交
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        one1.next = two1;
        two1.next = three1;
        three1.next = four1;
        four1.next = five;
        five.next = six;
        six.next = seven;

        ListNode intersection = isIntersect(one, one1);
        System.out.println(intersection.val);
    }

}
