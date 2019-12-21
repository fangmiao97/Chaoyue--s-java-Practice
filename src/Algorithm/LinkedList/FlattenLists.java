package Algorithm.LinkedList;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/21 16:15
 * @Description：扁平化多重链表
 * 3 → 11 → 15 → 30
 * ↓    ↓    ↓    ↓
 * 6    21   22   39
 * ↓         ↓    ↓
 * 8         50   40
 *
 * 扁平化为
 * 3 6 8 11 15 21 22 30 39 40 50
 */

class Node {
    int data;
    Node right, down;
    Node(int data) {
        this.data = data;
        this.right = null;
        this.down = null;
    }
}

public class FlattenLists {
    
    /**
     * @Description: 合并两个有序的链表
     * @Param:  [a, b]
     * @Return: Algorithm.LinkedList.Node
     * @Author: FANG MIAO
     * @Date: 16:41
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static Node merge(Node a, Node b) {
        //有一个链表为空，直接返回另外一个
        if(a == null)
            return b;
        if (b == null)
            return a;

        //把两个链表头中较小的赋给result，归并
        Node res;
        if (a.data < b.data) {
            res = a;
            res.down = merge(a.down, b);
        }
        else {
            res = b;
            res.down = merge(a, b.down);
        }

        return res;
    }

    /**
     * @Description: 递归扁平化链表
     * @Param:  [node]
     * @Return: Algorithm.LinkedList.Node
     * @Author: FANG MIAO
     * @Date: 16:49
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static Node flatten(Node node) {
        if (node == null || node.right == null)
            return node;

        node.right = flatten(node.right);
        node = merge(node, node.right);
        return node;
    }
    public static void main(String[] args) {
        Node three = new Node(3);
        Node six = new Node(6);
        Node eight = new Node(8);
        Node eleven = new Node(11);
        Node fifteen = new Node(15);
        Node twenty_one = new Node(21);
        Node twenty_two = new Node(22);
        Node thrity = new Node(30);
        Node thrity_nine = new Node(39);
        Node fourty = new Node(40);
        Node fifty = new Node(50);

        three.down = six;
        six.down = eight;

        eleven.down = twenty_one;

        fifteen.down = twenty_two;
        twenty_two.down = fifty;

        thrity.down = thrity_nine;
        thrity_nine.down = fourty;

        three.right = eleven;
        eleven.right = fifteen;
        fifteen.right = thrity;

        Node res = flatten(three);
        for (Node cur = res; cur != null; cur = cur.down) {
            System.out.print(cur.data + " ");
        }

    }
}
