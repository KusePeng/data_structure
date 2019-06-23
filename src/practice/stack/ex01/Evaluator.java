package practice.stack.ex01;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Description 利用栈实现无括号表达式求值
 * @Created by XP
 * @Date 2019/6/23
 */
public class Evaluator {
    private static final Pattern numReg = Pattern.compile("(^[0-9]*$)");
    private static final Pattern opReg = Pattern.compile("[+|\\-|*|/]");
    private static ArrayStack numStack = new ArrayStack(10);
    private static ArrayStack opStack = new ArrayStack(10);
    //运算符优先级
    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("+", 1);
        map.put("-", 1);
        map.put("/", 2);
        map.put("*", 2);
    }

    /**
     * @param expression 用一个空格符分隔的表达式
     * @return
     */
    public static String calculate(String expression) {
        String[] str = expression.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (numReg.matcher(str[i]).matches()) {
                if (i == (str.length - 1)) {
                    numPush(str[i], true);
                } else {
                    numPush(str[i], false);
                }

            } else if (opReg.matcher(str[i]).matches()) {
                opPush(str[i]);
            } else {
                return "表达式有误";
            }
        }
        return numStack.pop();
    }

    /**
     * 操作数入栈判断是否为最后一个数进行计算
     */
    public static void numPush(String s, boolean lastNum) {
        if (!lastNum) {
            numStack.push(s);
        } else {
            String op = opStack.pop();
            if (op == null) {
                numStack.push(s);
                return;
            }
            String strNum1 = numStack.pop();
            Integer calculate = handle(Integer.valueOf(strNum1), Integer.valueOf(s), op);
            numPush(calculate + "", true);
        }
    }


    /**
     * 操作符入栈时判断操作符优先级并计算
     *
     * @param s
     */
    private static void opPush(String s) {
        String peek = opStack.peek();
        if (peek != null) {
            Integer i = map.get(s);
            Integer j = map.get(peek);
            if (i > j) {
                opStack.push(s);
            } else {
                String op = opStack.pop();
                String strNum2 = numStack.pop();
                String strNum1 = numStack.pop();
                Integer calculate = handle(Integer.valueOf(strNum1), Integer.valueOf(strNum2), op);
                numStack.push(calculate + "");
                opPush(s);
            }
        } else {
            opStack.push(s);
        }
    }

    /**
     * 计算操作
     *
     * @param num1
     * @param num2
     * @param op
     * @return
     */
    private static Integer handle(int num1, int num2, String op) {
        Integer result = null;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String expression = "1 + 18 * 2 * 10 / 2 + 3 - 4 + 5";
        String result = calculate(expression);
        System.out.println(result);
    }

}
