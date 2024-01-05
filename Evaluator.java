package com.mahdicodes.matheval;

import java.util.ArrayList;
import java.util.LinkedList;

public class Evaluator { // HI I'M MD MAHDI TAJWAR RAEED. I'M NOT SURE IF ANYONE WILL EVER READ THIS CODE, BUT STILL I'LL
                         // PUT EXPLANATION-COMMENTS SO THAT ANYONE (INCLUDING ME) CAN UNDERSTAND THIS CODE IF A MODIFICATION
                         // IS REQUIRED.

    private static LinkedList<Character> evaluateSimpleExpression(LinkedList<Character> list) {
        // I WILL USE THIS FUNCTION TO EVALUATE EXPRESSIONS THAT DON'T CONTAIN ANY BRACKETS (E.G. THE INNER EXPRESSION WITHIN BRACKETS).

        // B.D.M.A.S RULE -> NO BRACKETS, SO DIVISION FIRST
        while (list.contains('/')){ // AT EVERY ITERATION, THIS LOOP EVALUATES AN EXPRESSION OF 2 NUMBERS. E.G. 1/-2/3; 1/-2 WILL BE CARRIED OUT FIRST THEN DIVIDED BY 3.
            int index_of_op = list.indexOf('/');
            int index_of_first_num_firstchar = 0;
            int index_of_second_num_lastchar = list.size()-1;
            String num1_str = "";
            String num2_str = "";
            double num1, num2, res;

            for (int i = index_of_op-1; i >= 0; i --){ // FINDING THE INDEX OF THE CHARACTER FROM WHERE THE FIRST NUMBER STARTS BY MOVING BACKWARDS FROM THE INDEX OF THE OPERATOR.
                char current_char = list.get(i);
                if (current_char == '+' || current_char == '*' || current_char == '/' || current_char == '-') {
                    index_of_first_num_firstchar = i + 1; // IF THE CURRENT CHARACTER IS ANOTHER OPERATOR, THEN IT MEANS THE CHARACTER AFTER THIS OPERATOR IS THE FIRST CHARACTER OF THE FIRST NUMBER. E.G. 1+2/3; 2 IS RIGHT AFTER THE +.
                    if (current_char == '-') index_of_first_num_firstchar --; // IF THE CURRENT CHARACTER IS A MINUS, THEN IT ISN'T JUST AN OPERATOR. RATHER, IT MEANS THE FIRST NUMBER IS NEGATIVE. HENCE THE MINUS IS TO BE INCLUDED AS WELL.
                    break;
                }
            }

            for (int i = index_of_op+1; i < list.size(); i ++){ // FINDING THE INDEX OF THE CHARACTER FROM WHERE THE SECOND NUMBER STARTS BY MOVING FORWARDS FROM THE INDEX OF THE OPERATOR.
                char current_char = list.get(i);
                if (current_char == '+' || current_char == '*' || current_char == '/' || current_char == '-') {
                    if (current_char == '-' && i == index_of_op+1) continue; // IF THERE'S A MINUS SIGN RIGHT AFTER THE OPERATOR THEN IT SIMPLY MEANS THE SECOND NUMBER IS NEGATIVE, AND IT IS TO BE INCLUDED WITH THE SECOND NUMBER.
                    index_of_second_num_lastchar = i - 1;
                    break;
                }
            }

            for (int i = index_of_first_num_firstchar; i < index_of_op; i ++){ // GETTING THE FIRST NUMBER
                num1_str = num1_str + list.get(i);
            }

            for (int i = index_of_op+1; i <= index_of_second_num_lastchar; i ++){ // GETTING THE SECOND NUMBER
                num2_str = num2_str + list.get(i);
            }

            num1 = Double.parseDouble(num1_str);
            num2 = Double.parseDouble(num2_str);
            res = num1 / num2; // THE RESULT IS CALCULATED HERE.

            char[] resArr = Double.toString(res).toCharArray();
            ArrayList<Character> resList = new ArrayList<>();
            for (char c: resArr) resList.add(c); // THE RESULT IS CONVERTED TO AN ARRAYLIST.
            list.subList(index_of_first_num_firstchar, index_of_second_num_lastchar+1).clear(); // REMOVING THE EVALUATED INNER EXPRESSION OF THE TWO NUMBERS, FROM THE GIVEN EXPRESSION.
            list.addAll(index_of_first_num_firstchar, resList); // THE RESULT OF THAT EVALUATED EXPRESSION REPLACES WHAT I REMOVED IN THE PREVIOUS SENTENCE. E.G. 1/-2/3 BECOMES -0.5/3.

            // THIS PROCESS IS REPEATED UNTIL NO DIVISION SIGNS ARE IN THE GIVEN EXPRESSION.
        }

        // MULTIPLICATION -> THE PROCESS IS SAME AS THE DIVISION PROCESS.
        while (list.contains('*')){
            int index_of_op = list.indexOf('*');
            int index_of_first_num_firstchar = 0;
            int index_of_second_num_lastchar = list.size()-1;
            String num1_str = "";
            String num2_str = "";
            double num1, num2, res;

            for (int i = index_of_op-1; i >= 0; i --){
                char current_char = list.get(i);
                if (current_char == '+' || current_char == '*' || current_char == '/' || current_char == '-') {
                    index_of_first_num_firstchar = i + 1;
                    if (current_char == '-') index_of_first_num_firstchar --;
                    break;
                }
            }

            for (int i = index_of_op+1; i < list.size(); i ++){
                char current_char = list.get(i);
                if (current_char == '+' || current_char == '*' || current_char == '/' || current_char == '-') {
                    if (current_char == '-' && i == index_of_op+1) continue;
                    index_of_second_num_lastchar = i - 1;
                    break;
                }
            }

            for (int i = index_of_first_num_firstchar; i < index_of_op; i ++){
                num1_str = num1_str + list.get(i);
            }

            for (int i = index_of_op+1; i <= index_of_second_num_lastchar; i ++){
                num2_str = num2_str + list.get(i);
            }

            num1 = Double.parseDouble(num1_str);
            num2 = Double.parseDouble(num2_str);
            res = num1 * num2;

            char[] resArr = Double.toString(res).toCharArray();
            ArrayList<Character> resList = new ArrayList<>();
            for (char c: resArr) resList.add(c);
            list.subList(index_of_first_num_firstchar, index_of_second_num_lastchar+1).clear();
            list.addAll(index_of_first_num_firstchar, resList);
        }

        // ADDITION -> THE PROCESS IS SAME AS THE DIVISION PROCESS.
        while (list.contains('+')){
            int index_of_op = list.indexOf('+');
            int index_of_first_num_firstchar = 0;
            int index_of_second_num_lastchar = list.size()-1;
            String num1_str = "";
            String num2_str = "";
            double num1, num2, res;

            for (int i = index_of_op-1; i >= 0; i --){
                char current_char = list.get(i);
                if (current_char == '+' || current_char == '*' || current_char == '/' || current_char == '-') {
                    index_of_first_num_firstchar = i + 1;
                    if (current_char == '-') index_of_first_num_firstchar --;
                    break;
                }
            }

            for (int i = index_of_op+1; i < list.size(); i ++){
                char current_char = list.get(i);
                if (current_char == '+' || current_char == '*' || current_char == '/' || current_char == '-') {
                    if (current_char == '-' && i == index_of_op+1) continue;
                    index_of_second_num_lastchar = i - 1;
                    break;
                }
            }

            for (int i = index_of_first_num_firstchar; i < index_of_op; i ++){
                num1_str = num1_str + list.get(i);
            }

            for (int i = index_of_op+1; i <= index_of_second_num_lastchar; i ++){
                num2_str = num2_str + list.get(i);
            }

            num1 = Double.parseDouble(num1_str);
            num2 = Double.parseDouble(num2_str);
            res = num1 + num2;

            char[] resArr = Double.toString(res).toCharArray();
            ArrayList<Character> resList = new ArrayList<>();
            for (char c: resArr) resList.add(c);
            list.subList(index_of_first_num_firstchar, index_of_second_num_lastchar+1).clear();
            list.addAll(index_of_first_num_firstchar, resList);
        }

        // SUBTRACTION -> THIS IS DIFFERENT FROM THE PROCESS OF THE DIVISION.
        while (list.contains('-')){
            int index_of_op = 0; // I NEED TO HANDLE THIS DIFFERENTLY AS, IF THE FIRST CHARACTER IS A MINUS THEN IT MEANS IT'S SIMPLY A NEGATIVE NUMBER. ALSO, I SET IT TO 0 TO REMOVE A COMPILER WARNING.
            boolean hasSubtraction = false;
            for (int i = 1; i < list.size(); i ++) {
                if (list.get(i) == '-') {
                    index_of_op = i;
                    hasSubtraction = true;
                    break;
                }
            }
            if (!hasSubtraction) break;

            int index_of_first_num_firstchar = 0;
            int index_of_second_num_lastchar = list.size()-1;
            String num1_str = "";
            String num2_str = "";
            double num1, num2, res;

            // THE INDEX OF THE FIRST CHARACTER OF THE FIRST NUMBER MUST BE 0, AS ALL OTHER OPERATIONS HAVE BEEN CARRIED OUT.

            for (int i = index_of_op+1; i < list.size(); i ++){
                char current_char = list.get(i);
                if (current_char == '+' || current_char == '*' || current_char == '/' || current_char == '-') {
                    if (i == index_of_op+1 && current_char == '-') continue; // THERE MAY BE DOUBLE MINUSES (ANOTHER MINUS AFTER THE CURRENT ONE) I.E. THE SECOND NUMBER MAY BE A SEPARATE NEGATIVE NUMBER. E.G. 2 - -3.
                    index_of_second_num_lastchar = i - 1;
                    break;
                }
            }

            // THE REMAINING PROCESS IS SAME AS THE DIVISION PROCESS.
            for (int i = index_of_first_num_firstchar; i < index_of_op; i ++){
                num1_str = num1_str + list.get(i);
            }

            for (int i = index_of_op+1; i <= index_of_second_num_lastchar; i ++){
                num2_str = num2_str + list.get(i);
            }

            num1 = Double.parseDouble(num1_str);
            num2 = Double.parseDouble(num2_str);
            res = num1 - num2;

            char[] resArr = Double.toString(res).toCharArray();
            ArrayList<Character> resList = new ArrayList<>();
            for (char c: resArr) resList.add(c);
            list.subList(index_of_first_num_firstchar, index_of_second_num_lastchar+1).clear();
            list.addAll(index_of_first_num_firstchar, resList);
        }

        // AFTER ALL THE LOOPS HAVE BEEN COMPLETED, I OBTAIN A SINGLE POSITIVE OR NEGATIVE NUMBER, AND RETURN IT IN THE FORM OF A LIST OF INDIVIDUAL CHARACTERS.
        return list;
    }

    private static String evaluate(String exp){
        if (exp.contains(" ")) exp = exp.replace(" ", ""); // REMOVING SPACES
        char[] expArr;
        char startingBracket = '('; // DEFAULT VALUE
        LinkedList<Character> list = new LinkedList<>();
        expArr = exp.toCharArray();
        for (char c: expArr) list.add(c); // I CONVERTED THE EXPRESSION TO A LIST OF INDIVIDUAL CHARACTERS.

        while (list.contains('[') || list.contains('{') || list.contains('(')) { // I'LL EVALUATE THE EXPRESSIONS INSIDE THE BRACKETS FIRST.

            int index_of_innermost_openingbracket = 0; // DEFAULT VALUE
            int index_of_innermost_closingbracket = list.size()-1; // DEFAULT VALUE
            // E.G. (1*(3+25)) HERE, THE INNERMOST BRACKETS ARE THE ONES CONTAINING 3+25.

            for (int i = list.size() - 1; i >= 0; i--) { // GOING BACKWARDS, THE FIRST STARTING BRACKET IS THE INNERMOST STARTING BRACKET.
                char current_char = list.get(i);
                if (current_char == '[' || current_char == '{' || current_char == '(') {
                    index_of_innermost_openingbracket = i;
                    startingBracket = current_char;
                    break;
                }
            }

            for (int i = index_of_innermost_openingbracket+1; i < list.size(); i ++){ // GOING FORWARDS FROM THE INDEX OF THE INNERMOST STARTING BRACKET, THE FIRST CLOSING BRACKET IS THE INNERMOST CLOSING BRACKET.
                char current_char = list.get(i);
                if ((startingBracket == '[' && current_char == ']') || (startingBracket == '{' && current_char == '}') || (startingBracket == '(' && current_char == ')')) { // TO AVOID MISMATCH OF BRACKETS
                    index_of_innermost_closingbracket = i;
                    break;
                }
            }

            // GETTING THE EXPRESSION INSIDE THE BRACKETS
            LinkedList<Character> bracketExp = new LinkedList<>(list.subList(index_of_innermost_openingbracket+1, index_of_innermost_closingbracket)); // THE BRACKETS THEMSELVES WON'T BE PASSED INTO THE SIMPLE EVALUATOR.
            LinkedList<Character> resList = evaluateSimpleExpression(bracketExp);
            list.subList(index_of_innermost_openingbracket, index_of_innermost_closingbracket+1).clear();  //I WROTE THE +1 AS IT'LL INCLUDE ITEMS "UNTIL" THAT INDEX, NOT "UP TO" THAT INDEX (I.E. I'M INCLUDING THE CLOSING BRACKET TOO).
            list.addAll(index_of_innermost_openingbracket, resList); // THE REMOVED INNER EXPRESSION IS REPLACED WITH THE RESULT OF IT.


            // THE LOOP GOES ON UNTIL NO BRACKETS EXIST IN THE GIVEN EXPRESSION.
        }

        // AFTER ALL BRACKETS HAVE BEEN DEALT WITH, I CAN EVALUATE THE REMAINING EXPRESSION WITH THE evaluateSimpleExpression() FUNCTION.
        list = evaluateSimpleExpression(list);
        return list.toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", ""); // AFTER USING LIST.TOSTRING() IT INCLUDES THE COMMAS AND SQUARE BRACKETS TOO, SO REMOVING THEM IS IMPORTANT.
    }

    public static double getResult(String expression){
        String resultStr = evaluate(expression);
        return Double.parseDouble(resultStr);
    }
}
