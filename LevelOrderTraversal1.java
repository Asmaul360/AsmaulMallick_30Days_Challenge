import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LevelOrderTraversal1{

    // Level Order Traversal (BFS)
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                q.add(current.left);
            }

            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    // Insert into Binary Tree (level order insertion)
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                q.add(temp.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes
        Node root = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            root = insert(root, data);
        }

        levelOrder(root);
    }
}