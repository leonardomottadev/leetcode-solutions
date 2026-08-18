class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("[");
        ListNode node = this;

        while (node != null) {
            resultado.append(node.val);

            if (node.next != null) {
                resultado.append(",");
            }

            node = node.next;
        }

        resultado.append("]");
        return resultado.toString();
    }
}