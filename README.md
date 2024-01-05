# Java Mathematical Expression Evaluator
### Evaluates mathematical expressions containing brackets, division, multiplication, addition and subtraction stored in strings
### Algorithm written by Md Mahdi Tajwar Raeed (January 2024)
#### mahdi05tazwar@gmail.com
<br>

## The getResult() Method (for users)
This is a public static method which returns the result of a given expression as a double. The parameter exp is a string.
### Usage
* String result = Evaluator.evaluate(exp)
<br>

## The evaluate() Method (required for getResult())
This is a private static method which returns the result of a given expression.
The return type is String. The parameter is a string.
### Procedure (how it works)
The string is converted to a Linked List of characters. Empty characters are removed.
* The list is read backwards using a for-loop, and the position of the first opening/starting bracket is stored. This is the innermost opening bracket.
* The list is read forwards using a for-loop, starting from the index of the opening bracket, and the index of the first closing bracket found is stored. This is the innermost closing bracket.
* The inner expression within these brackets is extracted (by the index values) and passed into the evaluateSimpleExpression() method. This method (described below) evaluates expressions that don't contain brackets. This is why I extracted the expression inside the innermost bracket (there's no inner bracket in it).
* The extracted inner expression is replaced by its result, in the list.
* This process is repeated until all expressions within brackets have been evaluated, and no brackets remain.
* The remaining expression doesn't have any brackets so once again the evaluateSimpleExpression() method is used to get the final result, which is returned as a double.
<br>

## The evaluateSimpleExpression() Method (required for getResult() and evaluate())
This is a private static method which evaluates expressions that don't contain brackets, as mentioned above. It follows the "B.D.M.A.S" order of operations, but since it doesn't handle brackets, it starts from division.
The return type is LinkedList<Character>. The parameter is a Linked List that contains the expression to be evaluated.
### Procedure (how it works)
* A while-loop runs until no division operators remain. In each iteration, division between 2 numbers is evaluated. The process of each loop is:
  * The index of the first division operator is stored.
  * The list is read backwards using a for-loop from the index of the division operator. When another operator is found, it means the character right after that operator is the first character of the first number. E.g. 30+20/10/5; the "/" in "20/10" is the targeted division operator. The "+" is the first operator before it. The number after the "+" is the first character of the first number (i.e. "2" of "20"). The index of this character is stored. The for-loop ends.
  * The list is read forwards using a for-loop from the index of the division operator.  When another operator is found, it means the character right before that operator is the last character of the second number. E.g. 30+20/10/5; the "/" in "20/10" is the targeted division operator. The second "/" is the first operator after it. The number before the "/" is the last character of the first number (i.e. "0" of "10"). The index of this character is stored. The for-loop ends.
  * HOWEVER, in some cases, a "-" isn't just an operator; it rather means that a number is negative. If there is a "-" right before the first character of the first number, it means the first number is negative (and the index of the "-" is the index of the first character). If there is a "-" right after the target division operator, it means the second number is negative and that the "-" isn't just an operator, and the for-loop doesn't stop; it checks for the next one.
  * The two numbers are extracted (by the index values) and the first one is divided by the second.
  * The result of this division is returned as a list of characters.
* This process is repeated for multiplication, then addition.
* The process for subtraction is different (i.e. the while-loop works differently). The process of each iteration for subtraction is:
  * Only minuses remain in the list now. So, the first character of the first number is obviously at index 0 (e.g. -2 - -3 - 9).
  * The list is read forwards using a for-loop which starts from index 1 (index 0 might be another minus which should be included for negative numbers). When another "-" is located, it is stored as the target subtraction operator.
  * The list is read forwards again, using a for-loop which starts from the index of the subtraction operator, and when another "-" is found, it means the character right before that operator is the last character of the second number. The for-loop stops.
  * HOWEVER, like before, in some cases, a "-" isn't just an operator; it rather means that a number is negative. If there is a "-" right after the target division operator, it means the second number is negative and that the "-" isn't just an operator, and the for-loop doesn't stop; it checks for the next one.
* NOTE: Sometimes, there may be only one operator in an expression, and there is no other operator. For this reason, the default index of the first character of the first number is 0 (first element), and the default index of the last character of the last number is that of the last element.
* Once the list no longer contains any operators (except the "-" of negative numbers at the start), the list is returned.
