package practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution19Test {

    @Test
    public void remove1thFromEnd_5Nodes() {
        Solution19.ListNode node5 = new Solution19.ListNode(5, null);
        Solution19.ListNode node4 = new Solution19.ListNode(4, node5);
        Solution19.ListNode node3 = new Solution19.ListNode(3, node4);
        Solution19.ListNode node2 = new Solution19.ListNode(2, node3);
        Solution19.ListNode node1 = new Solution19.ListNode(1, node2);
        Solution19.ListNode lastOneRemoved = Solution19.removeNthFromEnd(node1, 1);

        Solution19.ListNode resultNode4 = new Solution19.ListNode(4, null);
        Solution19.ListNode resultNode3 = new Solution19.ListNode(3, resultNode4);
        Solution19.ListNode resultNode2 = new Solution19.ListNode(2, resultNode3);
        Solution19.ListNode resultNode1 = new Solution19.ListNode(1, resultNode2);

        assertEquals(resultNode1, lastOneRemoved);
    }

    @Test
    public void remove2thFromEnd_5Nodes() {
        Solution19.ListNode node5 = new Solution19.ListNode(5, null);
        Solution19.ListNode node4 = new Solution19.ListNode(4, node5);
        Solution19.ListNode node3 = new Solution19.ListNode(3, node4);
        Solution19.ListNode node2 = new Solution19.ListNode(2, node3);
        Solution19.ListNode node1 = new Solution19.ListNode(1, node2);
        Solution19.ListNode lastOneRemoved = Solution19.removeNthFromEnd(node1, 2);


        Solution19.ListNode resultNode4 = new Solution19.ListNode(5, null);
        Solution19.ListNode resultNode3 = new Solution19.ListNode(3, resultNode4);
        Solution19.ListNode resultNode2 = new Solution19.ListNode(2, resultNode3);
        Solution19.ListNode resultNode1 = new Solution19.ListNode(1, resultNode2);

        assertEquals(resultNode1, lastOneRemoved);
    }

    @Test
    public void remove1thFromEnd_1Nodes() {
        Solution19.ListNode node1 = new Solution19.ListNode(1, null);
        Solution19.ListNode lastOneRemoved = Solution19.removeNthFromEnd(node1, 1);

        assertNull(lastOneRemoved);
    }

    @Test
    public void remove2thFromEnd_2Nodes() {
        Solution19.ListNode node2 = new Solution19.ListNode(2, null);
        Solution19.ListNode node1 = new Solution19.ListNode(1, node2);
        Solution19.ListNode lastOneRemoved = Solution19.removeNthFromEnd(node1, 2);


        Solution19.ListNode resultNode1 = new Solution19.ListNode(2, null);

        assertEquals(resultNode1, lastOneRemoved);
    }

    @Test
    public void remove1thFromEnd_2Nodes() {
        Solution19.ListNode node2 = new Solution19.ListNode(2, null);
        Solution19.ListNode node1 = new Solution19.ListNode(1, node2);
        Solution19.ListNode lastOneRemoved = Solution19.removeNthFromEnd(node1, 1);


        Solution19.ListNode resultNode1 = new Solution19.ListNode(1, null);

        assertEquals(resultNode1, lastOneRemoved);
    }
}