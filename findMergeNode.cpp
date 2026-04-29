#include <bits/stdc++.h>
using namespace std;

// Definition of singly linked list node
class SinglyLinkedListNode {
public:
    int data;
    SinglyLinkedListNode* next;

    SinglyLinkedListNode(int value) {
        data = value;
        next = nullptr;
    }
};

// Function to find merge point
int findMergeNode(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    SinglyLinkedListNode* p1 = head1;
    SinglyLinkedListNode* p2 = head2;

    while (p1 != p2) {
        p1 = (p1 == nullptr) ? head2 : p1->next;
        p2 = (p2 == nullptr) ? head1 : p2->next;
    }

    return p1->data;
}

// Helper function to print list
void printList(SinglyLinkedListNode* head) {
    while (head != nullptr) {
        cout << head->data << " -> ";
        head = head->next;
    }
    cout << "NULL" << endl;
}

int main() {
    // Creating common part of the list
    SinglyLinkedListNode* common = new SinglyLinkedListNode(30);
    common->next = new SinglyLinkedListNode(40);
    common->next->next = new SinglyLinkedListNode(50);

    // First linked list: 10 -> 20 -> 30 -> 40 -> 50
    SinglyLinkedListNode* head1 = new SinglyLinkedListNode(10);
    head1->next = new SinglyLinkedListNode(20);
    head1->next->next = common;

    // Second linked list: 15 -> 30 -> 40 -> 50
    SinglyLinkedListNode* head2 = new SinglyLinkedListNode(15);
    head2->next = common;

    // Print lists
    cout << "List 1: ";
    printList(head1);

    cout << "List 2: ";
    printList(head2);

    // Find merge node
    int mergePoint = findMergeNode(head1, head2);

    cout << "Merge Point Value: " << mergePoint << endl;

    return 0;
}
