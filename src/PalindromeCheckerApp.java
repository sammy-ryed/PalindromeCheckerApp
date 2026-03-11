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
    }
}
