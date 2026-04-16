import java.util.*;

class Node {
    int value;
    Node nextNode;

    Node(int value) {
        this.value = value;
        this.nextNode = null;
    }
}

public class reverse {

    static void printReverse(Node current) {
        if (current == null) return;

        printReverse(current.nextNode);
        System.out.println(current.value);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCases = input.nextInt(); 
        while (testCases-- > 0) {
            int size = input.nextInt();

            Node start = null;
            Node last = null;

            for (int i = 0; i < size; i++) {
                int num = input.nextInt();
                Node tempNode = new Node(num);

                if (start == null) {
                    start = tempNode;
                    last = tempNode;
                } else {
                    last.nextNode = tempNode;
                    last = tempNode;
                }
            }

            printReverse(start);
        }

        input.close();
    }
}