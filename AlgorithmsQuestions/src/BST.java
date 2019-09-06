import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public TreeNode bstFromPreorder(int[] preorder) {
        Queue<Integer> nums = new LinkedList<Integer>();
        Queue<TreeNode> bst = new LinkedList<TreeNode>();
        TreeNode head = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            nums.add(preorder[i]);
        }
        bst.add(head);
        Integer left;
        Integer right;
        TreeNode node;
        TreeNode l;
        TreeNode r;
        while (nums.size() > 1) {
            node = bst.poll();
            left = nums.poll();
            right = nums.poll();
            l = new TreeNode(left);
            r = new TreeNode(right);
            node.left = l;
            node.right = r;
            bst.add(l);
            bst.add(r);
        }
        return head;
    }
    
    public class TreeNode {
        int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}