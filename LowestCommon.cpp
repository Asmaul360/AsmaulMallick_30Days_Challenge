#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int data;
    Node *left;
    Node *right;

    Node(int d) {
        data = d;
        left = NULL;
        right = NULL;
    }
};

class Solution {
public:
    // Insert into BST
    Node* insert(Node* root, int data) {
        if (root == NULL) {
            return new Node(data);
        } else {
            if (data <= root->data) {
                root->left = insert(root->left, data);
            } else {
                root->right = insert(root->right, data);
            }
            return root;
        }
    }

    // Find LCA in BST
    Node* lca(Node* root, int v1, int v2) {
        if (root == NULL) return NULL;

        // both values smaller → go left
        if (v1 < root->data && v2 < root->data) {
            return lca(root->left, v1, v2);
        }
        // both values greater → go right
        else if (v1 > root->data && v2 > root->data) {
            return lca(root->right, v1, v2);
        }
        // split happens → this is LCA
        return root;
    }
};

int main() {
    Solution myTree;
    Node* root = NULL;

    int t, data;
    cin >> t;

    while (t-- > 0) {
        cin >> data;
        root = myTree.insert(root, data);
    }

    int v1, v2;
    cin >> v1 >> v2;

    Node* ans = myTree.lca(root, v1, v2);
    cout << ans->data;

    return 0;
}
