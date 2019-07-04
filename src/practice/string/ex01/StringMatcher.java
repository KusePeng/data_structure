package practice.string.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 字符串匹配
 * @Created by XP
 * @Date 2019/7/4
 */
public class StringMatcher {


    /**
     * BF算法查找字符串
     *
     * @param source
     * @param pattern
     * @return
     */
    public static int getIndexByBF(String source, String pattern) {
        int i = 0, j = 0;
        int sLen = source.length();
        int pLen = pattern.length();
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        while (i < sLen && j < pLen) {
            if (src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        // 匹配成功
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * KMP算法查找字符串
     *
     * @param source
     * @param pattern
     * @return
     */
    public static int getIndexByKMP(String source, String pattern) {
        char[] sChar = source.toCharArray();
        char[] pChar = pattern.toCharArray();
        int sLen = sChar.length;
        int pLen = pChar.length;
        int i = -1, j = -1;
       //int[] next = getNextArray(pattern);
        int[] next = getNextArrayOfOptimal(pattern);
        while (i < sLen && j < pLen) {
            if (j == -1 || sChar[i] == pChar[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        }
        return -1;
    }

    /**
     * KMP算法关键计算模式串的字符数组
     *
     * @param pattern
     * @return
     */
    private static int[] getNextArray(String pattern) {
        char[] p = pattern.toCharArray();
        int len = p.length;
        int next[] = new int[len];
        if (len > 0) {
            int i = 0;
            int j = -1;
            next[0] = -1;
            while (i < len - 1) {
                if (j == -1 || p[i] == p[j]) {
                    i++;
                    j++;
                    next[i] = j;
                } else {
                    j = next[j];
                }
            }
        }
        //打印next数组
        //print(next);
        return next;
    }

    /**
     * KMP算法关键计算模式串的字符数组
     * 优化模式串相邻字符相同较多字符串情况
     *
     * @param pattern
     * @return
     */
    private static int[] getNextArrayOfOptimal(String pattern) {
        char[] p = pattern.toCharArray();
        int len = p.length;
        int next[] = new int[len];
        if (len > 0) {
            int i = 0;
            int j = -1;
            next[0] = -1;
            while (i < len - 1) {
                if (j == -1 || p[i] == p[j]) {
                    i++;
                    j++;
                    //优化部分
                    if (p[i] != p[j]) {
                        next[i] = j;
                    } else {
                        next[i] = next[j];
                    }
                } else {
                    j = next[j];
                }
            }
        }
        //打印next数组
        //print(next);
        return next;
    }

    public static void print(int[] arr) {
        List<String> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i + "");
        }
        System.out.println(list.stream().collect(Collectors.joining(",", "[", "]")));
    }

    public static void main(String[] args) {
        String source = "aaaaaaaaaaaaaaaaf";
        String pattern = "aaaaf";

        int indexByBF = getIndexByBF(source, pattern);
        System.out.println("BF返回下标：" + indexByBF);

        int indexByKMP = getIndexByKMP(source, pattern);
        System.out.println("KMP返回下标：" + indexByKMP);

        String substring = source.substring(indexByKMP, indexByKMP + pattern.length());
        System.out.println("按返回下标截取字符串：" + substring);

    }


}
