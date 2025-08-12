// 🔗 Deep Clone a Linked List with Random Pointer
// Three Approaches: HashMap (Two Pass), Interweaving (O(1) Space), Recursion + Memoization

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {

    // -------------------------------
    // Approach 1: HashMap (Two Pass)
    // -------------------------------
    // public Node copyRandomList_HashMap(Node head) {
    //     if (head == null) return null;

    //     Map<Node, Node> map = new HashMap<>();

    //     // 1st pass: create all nodes
    //     Node curr = head;
    //     while (curr != null) {
    //         map.put(curr, new Node(curr.val));
    //         curr = curr.next;
    //     }

    //     // 2nd pass: set next and random pointers
    //     curr = head;
    //     while (curr != null) {
    //         map.get(curr).next = map.get(curr.next);
    //         map.get(curr).random = map.get(curr.random);
    //         curr = curr.next;
    //     }

    //     return map.get(head);
    // }

    // ---------------------------------
    // Approach 2: Interweaving Method
    // ---------------------------------
    // public Node copyRandomList_Interweaving(Node head) {
    //     if (head == null) return null;

    //     Node curr = head;

    //     // Step 1: Insert copy nodes between original nodes
    //     while (curr != null) {
    //         Node copy = new Node(curr.val);
    //         copy.next = curr.next;
    //         curr.next = copy;
    //         curr = copy.next;
    //     }

    //     // Step 2: Set random pointers for copy nodes
    //     curr = head;
    //     while (curr != null) {
    //         if (curr.random != null) {
    //             curr.next.random = curr.random.next;
    //         }
    //         curr = curr.next.next;
    //     }

    //     // Step 3: Separate original and cloned lists
    //     curr = head;
    //     Node newHead = head.next;
    //     while (curr != null) {
    //         Node copy = curr.next;
    //         curr.next = copy.next;
    //         if (copy.next != null) {
    //             copy.next = copy.next.next;
    //         }
    //         curr = curr.next;
    //     }

    //     return newHead;
    // }

    // -----------------------------------------
    // Approach 3: Recursion + Memoization
    // -----------------------------------------
    private Map<Node, Node> memo = new HashMap<>();

    public Node copyRandomList_Recursion(Node head) {
        if (head == null) return null;

        if (memo.containsKey(head)) {
            return memo.get(head);
        }

        Node copy = new Node(head.val);
        memo.put(head, copy);

        copy.next = copyRandomList_Recursion(head.next);
        copy.random = copyRandomList_Recursion(head.random);

        return copy;
    }

    // -----------------------------------------
    // Test Example
    // -----------------------------------------
    // public static void main(String[] args) {
    //     Solution sol = new Solution();

    //     // Create sample list:
    //     Node node1 = new Node(7);
    //     Node node2 = new Node(13);
    //     Node node3 = new Node(11);
    //     Node node4 = new Node(10);
    //     Node node5 = new Node(1);

    //     node1.next = node2;
    //     node2.next = node3;
    //     node3.next = node4;
    //     node4.next = node5;

    //     node2.random = node1;
    //     node3.random = node5;
    //     node4.random = node3;
    //     node5.random = node1;

    //     // Choose the approach:
    //     Node cloned = sol.copyRandomList_Interweaving(node1);

    //     // Print original and cloned values to verify
    //     Node curr = cloned;
    //     while (curr != null) {
    //         int randomVal = (curr.random != null) ? curr.random.val : -1;
    //         System.out.println("Node: " + curr.val + ", Random: " + randomVal);
    //         curr = curr.next;
    //     }
    // }
}
