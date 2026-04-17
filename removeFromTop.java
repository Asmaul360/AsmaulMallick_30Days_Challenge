import java.util.*;

public class removeFromTop {

    public static int equalStacks(List<Integer> stack1, List<Integer> stack2, List<Integer> stack3) {

        int height1 = 0, height2 = 0, height3 = 0;

    
        for (int value : stack1) height1 += value;
        for (int value : stack2) height2 += value;
        for (int value : stack3) height3 += value;

        int topIndex1 = 0, topIndex2 = 0, topIndex3 = 0;

        while (true) {
            if (topIndex1 == stack1.size() || 
                topIndex2 == stack2.size() || 
                topIndex3 == stack3.size()) {
                return 0;
            }
            if (height1 == height2 && height2 == height3) {
                return height1;
            }

            if (height1 >= height2 && height1 >= height3) {
                height1 -= stack1.get(topIndex1++);
            } else if (height2 >= height1 && height2 >= height3) {
                height2 -= stack2.get(topIndex2++);
            } else {
                height3 -= stack3.get(topIndex3++);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size1 = input.nextInt();
        int size2 = input.nextInt();
        int size3 = input.nextInt();

        List<Integer> stack1 = new ArrayList<>();
        List<Integer> stack2 = new ArrayList<>();
        List<Integer> stack3 = new ArrayList<>();

        for (int i = 0; i < size1; i++) stack1.add(input.nextInt());
        for (int i = 0; i < size2; i++) stack2.add(input.nextInt());
        for (int i = 0; i < size3; i++) stack3.add(input.nextInt());

        int result = equalStacks(stack1, stack2, stack3);
        System.out.println(result);

        input.close();
    }
}