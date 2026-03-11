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
    }
}
