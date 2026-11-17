import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Permutations");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] View Elements");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addElements();
                    break;
                case 2:
                    displayQueue();
                    break;
                case 3:
                    generatePermutations();
                    break;
                case 4:
                    System.out.println("Thank you and goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void addElements() {
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter element " + i + ": ");
            queue.add(input.next());
        }
        System.out.println(n + " element(s) enqueued.");
        displayQueue();

        if (queue.size() >= 2) {
            System.out.println("Dequeuing two elements...");
            for (int i = 0; i < 2; i++) {
                queue.poll();
            }
            displayQueue();
        }
    }

    static void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements.");
        } else {
            System.out.println("Queue: " + queue);
        }
    }

    static String[] queueToArray() {
        String[] items = new String[queue.size()];
        int i = 0;

        for (String s : queue) {
            items[i++] = s;
        }
        return items;
    }

    static void generatePermutations() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add Elements.");
            return;
        }
        displayQueue();
        String[] items = queueToArray();
        int n = items.length;

        System.out.print("Enter number of elements to arrange: ");
        int r = input.nextInt();
        if (r < 1 || r > n) {
            System.out.println("Invalid number. Enter a value from 1 to " + n + ".");
            return;
        }
        System.out.println();

        Queue<String> work = new LinkedList<>();
        work.add("");
        int count = 0;

        System.out.println("Generated Permutations: ");
        while (!work.isEmpty()) {
            String cur = work.poll();

            if (cur.length() == r) {
                System.out.println(cur);
                count++;
                continue;
            }

            for (String item : items) {
                if (!cur.contains(item)) {
                    work.add(cur + item);
                }
            }
        }
        System.out.println("\nTotal Permutations: " + count);
    }
}
