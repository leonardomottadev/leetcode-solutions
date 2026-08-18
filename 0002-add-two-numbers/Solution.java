/*

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

- The number of nodes in each linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.

*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String args[]) {
        // Exemplo 1
        // l1 = [2,4,3]
        ListNode l1Exemplo1 = new ListNode(2);
        l1Exemplo1.next = new ListNode(4);
        l1Exemplo1.next.next = new ListNode(3);

        // l2 = [5,6,4]
        ListNode l2Exemplo1 = new ListNode(5);
        l2Exemplo1.next = new ListNode(6);
        l2Exemplo1.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1Exemplo1, l2Exemplo1));


        // Exemplo 2
        // l1 = [0]
        ListNode l1Exemplo2 = new ListNode(0);

        // l2 = [0]
        ListNode l2Exemplo2 = new ListNode(0);

        System.out.println(addTwoNumbers(l1Exemplo2, l2Exemplo2));


        // Exemplo 3
        // l1 = [9,9,9,9,9,9,9]
        ListNode l1Exemplo3 = new ListNode(9);
        l1Exemplo3.next = new ListNode(9);
        l1Exemplo3.next.next = new ListNode(9);
        l1Exemplo3.next.next.next = new ListNode(9);
        l1Exemplo3.next.next.next.next = new ListNode(9);
        l1Exemplo3.next.next.next.next.next = new ListNode(9);
        l1Exemplo3.next.next.next.next.next.next = new ListNode(9);

        // l2 = [9,9,9,9]
        ListNode l2Exemplo3 = new ListNode(9);
        l2Exemplo3.next = new ListNode(9);
        l2Exemplo3.next.next = new ListNode(9);
        l2Exemplo3.next.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(l1Exemplo3, l2Exemplo3));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int addNext = 0;
        int result = l1.val + l2.val + addNext;
        if(result > 9) {
            addNext = result / 10;
            result = result % 10;
        } else {
            addNext = 0;
        }

        ListNode response = new ListNode(result);
        ListNode initialResponseNode = response;

        while(true) {
            if(l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1.next != null && l2.next == null) {
                l1 = l1.next;
                l2 = new ListNode(0);
            } 
            else if(l1.next == null && l2.next != null) {
                l1 = new ListNode(0);
                l2 = l2.next;
            }
            else {
                if(addNext != 0) {
                    response.next = new ListNode(addNext);
                }
                break;
            }
            result = l1.val + l2.val + addNext;
            if(result > 9) {
                addNext = result / 10;
                result = result % 10;
            } else {
                addNext = 0;
            }
            response.next = new ListNode(result);
            response = response.next;
        }
        return initialResponseNode;
    }
}