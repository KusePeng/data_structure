package practice.stack.ex01;

/**
 * @Description 利用栈进行括号匹配
 * @Created by XP
 * @Date 2019/6/23
 */
public class Matching {


    public static boolean matching(String reg) {
        ArrayStack stack = new ArrayStack(10);
        if (reg == null || reg == "" || reg.length() == 0) {
            return false;
        }
        String[] split = reg.split("");
        for (String s : split) {
            if (s.equals("{") || s.equals("(") || s.equals("[")) {
                stack.push(s);
            } else {
                String pop = stack.pop();
                if (pop.equals("{") && s.equals("}")) {
                    continue;
                } else if (pop.equals("(") && s.equals(")")) {
                    continue;
                } else if (pop.equals("[") && s.equals("]")) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String reg = "{([)]}";
        boolean result = matching(reg);
        System.out.println(result);
    }
}
