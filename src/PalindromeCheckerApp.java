import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1 - Application Entry & Welcome Message
        System.out.println("========================================");
        System.out.println("   Welcome to Palindrome Checker App   ");
        System.out.println("========================================");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Version          : 1.0");
        System.out.println("========================================");

        // UC2 - Hardcoded Palindrome Check
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        System.out.println("\n--- UC2: Hardcoded Palindrome Check ---");
        System.out.println("Word   : " + word);

        if (word.equals(reversed)) {
            System.out.println("Result : \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + word + "\" is NOT a Palindrome.");
        }

        // UC3 - Palindrome Check Using String Reverse (for loop)
        String input = "racecar";
        String reversedStr = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversedStr = reversedStr + input.charAt(i);
        }

        System.out.println("\n--- UC3: Palindrome Check Using String Reverse ---");
        System.out.println("Input  : " + input);

        if (input.equals(reversedStr)) {
            System.out.println("Result : \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + input + "\" is NOT a Palindrome.");
        }

        // UC4 - Character Array Based Palindrome Check (Two-Pointer)
        String uc4Input = "level";
        char[] chars = uc4Input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("\n--- UC4: Character Array Based Palindrome Check ---");
        System.out.println("Input  : " + uc4Input);

        if (isPalindrome) {
            System.out.println("Result : \"" + uc4Input + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + uc4Input + "\" is NOT a Palindrome.");
        }

        // UC5 - Stack Based Palindrome Check
        String uc5Input = "deified";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < uc5Input.length(); i++) {
            stack.push(uc5Input.charAt(i));
        }

        String uc5Reversed = "";
        while (!stack.isEmpty()) {
            uc5Reversed = uc5Reversed + stack.pop();
        }

        System.out.println("\n--- UC5: Stack Based Palindrome Check ---");
        System.out.println("Input  : " + uc5Input);

        if (uc5Input.equals(uc5Reversed)) {
            System.out.println("Result : \"" + uc5Input + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + uc5Input + "\" is NOT a Palindrome.");
        }

        // UC6 - Queue vs Stack: FIFO vs LIFO Palindrome Check
        String uc6Input = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> uc6Stack = new Stack<>();

        for (int i = 0; i < uc6Input.length(); i++) {
            queue.add(uc6Input.charAt(i));      // Enqueue (FIFO)
            uc6Stack.push(uc6Input.charAt(i));  // Push (LIFO)
        }

        boolean uc6IsPalindrome = true;
        while (!queue.isEmpty()) {
            if (queue.poll() != uc6Stack.pop()) {  // Dequeue vs Pop
                uc6IsPalindrome = false;
                break;
            }
        }

        System.out.println("\n--- UC6: Queue vs Stack (FIFO vs LIFO) Palindrome Check ---");
        System.out.println("Input  : " + uc6Input);

        if (uc6IsPalindrome) {
            System.out.println("Result : \"" + uc6Input + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + uc6Input + "\" is NOT a Palindrome.");
        }

        // UC7 - Deque Based Optimized Palindrome Check
        String uc7Input = "rotator";
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < uc7Input.length(); i++) {
            deque.addLast(uc7Input.charAt(i));
        }

        boolean uc7IsPalindrome = true;
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                uc7IsPalindrome = false;
                break;
            }
        }

        System.out.println("\n--- UC7: Deque Based Optimized Palindrome Check ---");
        System.out.println("Input  : " + uc7Input);

        if (uc7IsPalindrome) {
            System.out.println("Result : \"" + uc7Input + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + uc7Input + "\" is NOT a Palindrome.");
        }

        // UC8 - Singly Linked List Based Palindrome Check
        String uc8Input = "noon";

        // Build linked list from string
        Node head = null;
        Node tail = null;
        for (int i = 0; i < uc8Input.length(); i++) {
            Node newNode = new Node(uc8Input.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Find middle using fast and slow pointer
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half in-place
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Compare first half and reversed second half
        Node left = head;
        Node right = prev;
        boolean uc8IsPalindrome = true;
        while (right != null) {
            if (left.data != right.data) {
                uc8IsPalindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        System.out.println("\n--- UC8: Singly Linked List Based Palindrome Check ---");
        System.out.println("Input  : " + uc8Input);

        if (uc8IsPalindrome) {
            System.out.println("Result : \"" + uc8Input + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + uc8Input + "\" is NOT a Palindrome.");
        }

        // UC9 - Recursive Palindrome Check
        String uc9Input = "refer";
        boolean uc9IsPalindrome = isPalindromeRecursive(uc9Input, 0, uc9Input.length() - 1);

        System.out.println("\n--- UC9: Recursive Palindrome Check ---");
        System.out.println("Input  : " + uc9Input);

        if (uc9IsPalindrome) {
            System.out.println("Result : \"" + uc9Input + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + uc9Input + "\" is NOT a Palindrome.");
        }

        // UC10 - Case and Space Insensitive Palindrome Check
        String uc10Input = "A man a plan a canal Panama";

        // Normalize: remove non-alphanumeric characters and convert to lowercase
        String normalized = uc10Input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Two-pointer check on normalized string
        int uc10Left = 0;
        int uc10Right = normalized.length() - 1;
        boolean uc10IsPalindrome = true;

        while (uc10Left < uc10Right) {
            if (normalized.charAt(uc10Left) != normalized.charAt(uc10Right)) {
                uc10IsPalindrome = false;
                break;
            }
            uc10Left++;
            uc10Right--;
        }

        System.out.println("\n--- UC10: Case and Space Insensitive Palindrome Check ---");
        System.out.println("Input      : " + uc10Input);
        System.out.println("Normalized : " + normalized);

        if (uc10IsPalindrome) {
            System.out.println("Result : \"" + uc10Input + "\" is a Palindrome.");
        } else {
            System.out.println("Result : \"" + uc10Input + "\" is NOT a Palindrome.");
        }

        // UC11 - OOP Encapsulated Palindrome Check
        PalindromeChecker checker = new PalindromeChecker();
        String uc11Input = "kayak";

        System.out.println("\n--- UC11: OOP Encapsulated Palindrome Check ---");
        System.out.println("Input  : " + uc11Input);
        System.out.println("Result : " + checker.checkPalindrome(uc11Input));

        // UC12 - Strategy Pattern: Dynamic Algorithm Selection
        String uc12Input = "repaper";

        System.out.println("\n--- UC12: Strategy Pattern Palindrome Check ---");
        System.out.println("Input  : " + uc12Input);

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        System.out.println("[StackStrategy]  Result : " + (stackStrategy.check(uc12Input) ? "\"" + uc12Input + "\" is a Palindrome." : "\"" + uc12Input + "\" is NOT a Palindrome."));
        System.out.println("[DequeStrategy]  Result : " + (dequeStrategy.check(uc12Input) ? "\"" + uc12Input + "\" is a Palindrome." : "\"" + uc12Input + "\" is NOT a Palindrome."));

        // UC13 - Performance Comparison of Palindrome Algorithms
        String uc13Input = "amanaplanacanalpanama";

        System.out.println("\n--- UC13: Performance Comparison of Palindrome Algorithms ---");
        System.out.println("Input  : " + uc13Input);
        System.out.println();

        // Approach 1: String reversal using StringBuilder
        long start1 = System.nanoTime();
        String rev = new StringBuilder(uc13Input).reverse().toString();
        boolean result1 = uc13Input.equals(rev);
        long end1 = System.nanoTime();
        System.out.println("Approach 1 - StringBuilder Reverse : " + (result1 ? "Palindrome" : "Not Palindrome") + " | Time: " + (end1 - start1) + " ns");

        // Approach 2: For loop string concatenation
        long start2 = System.nanoTime();
        String revLoop = "";
        for (int i = uc13Input.length() - 1; i >= 0; i--) {
            revLoop = revLoop + uc13Input.charAt(i);
        }
        boolean result2 = uc13Input.equals(revLoop);
        long end2 = System.nanoTime();
        System.out.println("Approach 2 - For Loop Concatenation : " + (result2 ? "Palindrome" : "Not Palindrome") + " | Time: " + (end2 - start2) + " ns");

        // Approach 3: Two-pointer char array
        long start3 = System.nanoTime();
        char[] ch = uc13Input.toCharArray();
        int l = 0, r = ch.length - 1;
        boolean result3 = true;
        while (l < r) {
            if (ch[l] != ch[r]) { result3 = false; break; }
            l++; r--;
        }
        long end3 = System.nanoTime();
        System.out.println("Approach 3 - Two-Pointer Char Array : " + (result3 ? "Palindrome" : "Not Palindrome") + " | Time: " + (end3 - start3) + " ns");

        // Approach 4: Stack-based
        long start4 = System.nanoTime();
        Stack<Character> perfStack = new Stack<>();
        for (int i = 0; i < uc13Input.length(); i++) perfStack.push(uc13Input.charAt(i));
        String revStack = "";
        while (!perfStack.isEmpty()) revStack = revStack + perfStack.pop();
        boolean result4 = uc13Input.equals(revStack);
        long end4 = System.nanoTime();
        System.out.println("Approach 4 - Stack Reversal        : " + (result4 ? "Palindrome" : "Not Palindrome") + " | Time: " + (end4 - start4) + " ns");

        // Approach 5: Deque-based
        long start5 = System.nanoTime();
        Deque<Character> perfDeque = new ArrayDeque<>();
        for (int i = 0; i < uc13Input.length(); i++) perfDeque.addLast(uc13Input.charAt(i));
        boolean result5 = true;
        while (perfDeque.size() > 1) {
            if (perfDeque.removeFirst() != perfDeque.removeLast()) { result5 = false; break; }
        }
        long end5 = System.nanoTime();
        System.out.println("Approach 5 - Deque Front/Rear      : " + (result5 ? "Palindrome" : "Not Palindrome") + " | Time: " + (end5 - start5) + " ns");
    }

    // UC11 - PalindromeChecker class (Encapsulation + Single Responsibility)
    static class PalindromeChecker {
        public String checkPalindrome(String word) {
            char[] chars = word.toCharArray();
            int left = 0;
            int right = chars.length - 1;

            while (left < right) {
                if (chars[left] != chars[right]) {
                    return "\"" + word + "\" is NOT a Palindrome.";
                }
                left++;
                right--;
            }
            return "\"" + word + "\" is a Palindrome.";
        }
    }

    // UC9 - Recursive helper method
    static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base condition: single char or pointers crossed
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // Node class for Singly Linked List (UC8)
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // UC12 - Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // UC12 - Stack Strategy (LIFO)
    static class StackStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }
            String reversed = "";
            while (!stack.isEmpty()) {
                reversed = reversed + stack.pop();
            }
            return input.equals(reversed);
        }
    }

    // UC12 - Deque Strategy (Double Ended Queue)
    static class DequeStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < input.length(); i++) {
                deque.addLast(input.charAt(i));
            }
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }
}
