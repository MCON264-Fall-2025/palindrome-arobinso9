package com.example.palindrome;
import java.util.Stack;
import java.util.Queue;
public class PalindromeWithStackQueue {

    /**
     * Implement a method that uses a Stack and a Queue
     * to determine whether the input string is a palindrome.
     * Palindromes read the same forwards and backwards,
     * ignoring case and non-alphanumeric characters.
     * Use Stack and Queue provided by Java's standard library.
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        int length = s.length();
        char ch;

        // Create stack and queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new java.util.LinkedList<>();

        // Obtain and handle characters
        for (int i = 0; i < length; i++) {
            ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                ch = Character.toLowerCase(ch);
                stack.push(ch);
                queue.add(ch);
            }
        }

        // Determine if palindrome
        boolean stillPalindrome = true;
        while (stillPalindrome && !stack.isEmpty()) {
            char fromStack = stack.pop();
            char fromQueue = queue.remove();

            if (fromStack != fromQueue) {
                stillPalindrome = false;
            }
        }

        // Return result
        return stillPalindrome;
    }

    // Optional helper method for normalization
    public static String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}

