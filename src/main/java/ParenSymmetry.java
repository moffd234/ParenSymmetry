package src.main.java;

import java.util.Arrays;  // Used for filling openParenArray

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        // implement this method
        char[] characterArray = s.toCharArray();
        if(characterArray.length == 0){
            return false;
        }
        char[] openParenArray = new char[characterArray.length];
        Arrays.fill(openParenArray, ' ');
        int index = 0;
        // Add open brackets, curly braces, etc. to an array
        for(char c: characterArray){
            if(c == '(' ){
                openParenArray[index] = c;
                index++;
            }
            // Remove last occurrence of the character when a corresponding closing character is found
            // Then update the index
            else if(c == ')' ){
                if(openParenArray[0] != '('){
                    return false;
                }
                openParenArray[index - 1] = ' ';

                index--;
            }
        }

        // Check if the array is empty and return true if so
        // else - return false
        return openParenArray[0] == ' ';
    }

    private void checkFile(String filename) {
        // open file named filename

        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        System.out.println("Should = false. Actual Answer = " + ps.isBalanced("("));
        System.out.println("Should = false. Actual Answer = " + ps.isBalanced("(("));
        System.out.println("Should = false. Actual Answer = " + ps.isBalanced(")"));
        System.out.println("Should = false. Actual Answer = " + ps.isBalanced(""));
        System.out.println("Should = false. Actual Answer = " + ps.isBalanced("(()())((())))"));;
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};

        System.out.println("Should = true. Actual Answer = " + ps.isBalanced("()"));
        System.out.println("Should = true. Actual Answer = " + ps.isBalanced("(())"));
        System.out.println("Should = true. Actual Answer = " + ps.isBalanced("(((())))"));
        System.out.println("Should = true. Actual Answer = " + ps.isBalanced("(()())((()))"));
        System.out.println("Should = true. Actual Answer = " + ps.isBalanced("(   )"));
        System.out.println("Should = true. Actual Answer = " + ps.isBalanced("( () ( ) )( () ( ) )"));
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
