public class Solution19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int index = 1;
        ListNode oneBeforeNthFromEnd = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (index > n) {
                oneBeforeNthFromEnd = oneBeforeNthFromEnd.next;
            }
            index++;
            cur = cur.next;
        }
        if (oneBeforeNthFromEnd.next == null) {
            return null;
        } else if (oneBeforeNthFromEnd == head) {
            head = head.next;
        } else {
            oneBeforeNthFromEnd.next = oneBeforeNthFromEnd.next.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;

            if (val != listNode.val) return false;
            return next != null ? next.equals(listNode.next) : listNode.next == null;
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return val + ", " + next;
        }
    }
}
