package LeetCode;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 4
 * 1 2 2
 * 2 3 -1
 * 2 4 2
 */

public class MaxWeightEdge {

    static class TreeNode {
        int val;
        int weight;
        TreeNode left;
        TreeNode right;
        TreeNode(int x, int w) { val = x; weight = w;}
    }

    public static LinkedHashMap<Integer, TreeNode> table = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(n);
        while(table.size() < n) {
            int root = in.nextInt();
            System.out.println(root);
            int child = in.nextInt();
            System.out.println(child);
            int cweight = in.nextInt();
            System.out.println(cweight);

            TreeNode rootNode = new TreeNode(0,0);

            if(!table.containsKey(root)) {
                rootNode = new TreeNode(root, 0);
                table.put(root, rootNode);
                System.out.println("creat root" + root);
            }else {
                rootNode = table.get(root);
                System.out.println("get root" + root);
            }

            TreeNode childNode = new TreeNode(0,0);
            if(!table.containsKey(child)) {
                childNode = new TreeNode(child, cweight);
                table.put(child, childNode);
                System.out.println("creat child" + child);
            }else {
                childNode = table.get(child);
                System.out.println("get child" + child);
            }

            if(rootNode.left == null){
                rootNode.left = childNode;
                System.out.println("root" + rootNode.val + " left node is " + childNode.val);
            }
            else {
                rootNode.right = childNode;
                System.out.println("root" + rootNode.val + " right node is " + childNode.val);

            }
        }

        System.out.println("here");

        for (TreeNode node: table.values()) {
            System.out.print(Math.max(dfs(node.left, 0, 0), dfs(node.right, 0,0)));
            System.out.print(" ");
        }


    }

    public static int dfs(TreeNode root, int weightSum, int max) {

        if (root == null)
            return 0;

        weightSum += root.weight;
        max = Math.max(max, weightSum);

        return root.left == root.right ? max : Math.max(dfs(root.left, weightSum, max),
                dfs(root.right, weightSum, max));
    }
}
