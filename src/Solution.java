import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(isValidExpression(string));
        System.out.println(isPalindrome(string));
    }

    private static boolean isPalindrome(String string) {
        ArrayDeque<Character> stringQueue = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            stringQueue.addFirst(string.toLowerCase().charAt(i));
        }
        while (stringQueue.size() > 1) {
            if (stringQueue.removeFirst() != stringQueue.removeLast()) return false;
        }
        return true;
    }

    private static boolean isValidExpression(String expression){
        Stack<Character> expressionStack=new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i)=='(' || expression.charAt(i)=='{' || expression.charAt(i)=='['){
                expressionStack.push(expression.charAt(i));
            } else if(expression.charAt(i)==')' || expression.charAt(i)=='}' || expression.charAt(i)==']') {
                if(expressionStack.isEmpty()) return false;
                if(expression.charAt(i)==')'){
                    if(expressionStack.pop()!='(') return false;
                } else if(expression.charAt(i)=='}'){
                    if(expressionStack.pop()!='{') return false;
                } else if(expression.charAt(i)==']'){
                    if(expressionStack.pop()!='[') return false;
                }
            }
        }
        if(expressionStack.isEmpty()) return true;
        return false;
    }

}
