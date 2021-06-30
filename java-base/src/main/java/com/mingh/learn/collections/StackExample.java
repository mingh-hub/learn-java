package com.mingh.learn.collections;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName StackExample
 * @Author Hai.Ming
 * @Date 2021/6/13 16:14
 * @Description java.util.Stack ★ extends java.util.Vector
 *                      1. Stack 是栈的数据结构实现, LIFO, 具体应用如网页的回退功能, 文本编辑器的撤销功能
 *                      2. 在调用 pop() 方法弹出时, 如果没有元素则会报异常
 */
public class StackExample {

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 21:52
     * @Description 利用 Stack 的 LIFO, 实现字符串反转
     **/
    public String reverse(String str) {
        Stack<Character> charStack = new Stack<>();
        char[] charArray = str.toCharArray();
        char[] newCharArray = new char[charArray.length];
        for (char c : charArray) {
            charStack.push(c);
        }
        System.out.println(Arrays.toString(charArray));
        for (int i = 0; i < newCharArray.length; i++) {
            newCharArray[i] = charStack.pop();
        }
        System.out.println(Arrays.toString(newCharArray));
        return String.valueOf(newCharArray);
    }

    /**
     * @Author Hai.Ming
     * @Date 2021/6/13 16:23
     * @Description 观察 Stack 的压栈和出栈
     **/
    public void pushThenPop() {
        Stack<String> stack = new Stack<>();
        System.out.println("=======压栈=======");
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack);
        System.out.println("=======出栈=======");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("=======再出=======");
//        System.out.println(stack.pop());  // 栈内为空再出会有异常的 java.util.EmptyStackException
    }
}
