import java.io.*;

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    DoublyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Solution {

    // Function to insert in sorted doubly linked list
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        // Case 1: Empty list
        if (head == null) {
            return newNode;
        }

        // Case 2: Insert at beginning
        if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        // Case 3: Insert in middle or end
        DoublyLinkedListNode temp = head;

        while (temp.next != null && temp.next.data < data) {
            temp = temp.next;
        }

        newNode.next = temp.next;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    // Helper to print list
    static void printList(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Example: 1 <-> 2 <-> 4
        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
        head.next = new DoublyLinkedListNode(2);
        head.next.prev = head;
        head.next.next = new DoublyLinkedListNode(4);
        head.next.next.prev = head.next;

        int data = 3;

        head = sortedInsert(head, data);

        printList(head); // Output: 1 2 3 4
    }
}