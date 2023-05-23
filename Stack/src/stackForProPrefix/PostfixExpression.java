/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackForProPrefix;

import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixExpression {

    static double evaluatePostFixExp(String exp) {
        double result = 0;
        StringTokenizer stk = new StringTokenizer(exp, "() ");
        Stack<Double> stack = new Stack<>();
        while (stk.hasMoreElements()) {
            String S = stk.nextToken();//1 2 * 3 4 * + 5 6 * + 2 *
            if (!S.equals("+") && !S.equals("-")
                    && !S.equals("*") && !S.equals("/")) {
                stack.push(Double.parseDouble(S));
            } else {
                double n1 = stack.pop();
                double n2 = stack.pop();
                if (S.equals("+")) {
                    result = n1 + n2;
                } else if (S.equals("-")) {
                    result = n1 - n2;
                } else if (S.equals("*")) {
                    result = n1 * n2;
                } else if (S.equals("/")) {
                    if (n2 == 0.0) {
                        throw new RuntimeException("Divide by 0!");
                    } else {
                        result = n1 / n2;
                    }
                } else {
                    throw new RuntimeException("This operator is not supported!");
                }
                stack.push(result);
            }
        }
        return result;
    }

    static double evaluatePreFixExp(String exp) {
       double result = 0;
//        StringBuilder str = new StringBuilder(exp);
//        String toCal = str.reverse().toString().trim();//* 2 + * 6 5 + * 4 3 * 2 1
        String[] arr = exp.split("\\s+");
        Stack<Double> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("+") && !arr[i].equals("-")
                    && !arr[i].equals("*") && !arr[i].equals("/")) {
                stack.push(Double.parseDouble(arr[i]));
            } else {
                double n1 = stack.pop();
                double n2 = stack.pop();
                if (arr[i].equals("+")) {
                    result = n1 + n2;
                } else if (arr[i].equals("-")) {
                    result = n1 - n2;
                } else if (arr[i].equals("*")) {
                    result = n1 * n2;
                } else if (arr[i].equals("/")) {
                    if (n2 == 0.0) {
                        throw new RuntimeException("Divide by 0!");
                    } else {
                        result = n1 / n2;
                    }
                } else {
                    throw new RuntimeException("This operator is not supported!");
                }
                stack.push(result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "1 2 * 3 4 * + 5 6 * + 2 *";
        String abc = "* 2 + * 6 5 + * 4 3 * 2 1";
        System.out.println(evaluatePostFixExp(exp));
//        System.out.println(evaluatePreFixExp(abc));
    }

}
