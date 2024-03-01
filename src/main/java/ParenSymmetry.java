package src.main.java;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

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

    private void checkFile(String filename) {// for each line in the file
        // open file named filename
        File inputFile = new File(filename);  // Create a File object w/ path of filename
        Scanner inputScanner;
        try {
            inputScanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            throw new RuntimeException(e);
        }

        while(inputScanner.hasNextLine()){
            // ASSERT: Scanner hasn't reached EOF
            String input = inputScanner.nextLine(); // read the line
            System.out.println(input + " = " + isBalanced(input)); // print whether or not the line's
                                                                   // parenthesis are balanced
        }
        inputScanner.close();

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();
        ps.checkFile("TestStrings0.txt");
        ps.checkFile("TestStrings1.txt");
        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};

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
