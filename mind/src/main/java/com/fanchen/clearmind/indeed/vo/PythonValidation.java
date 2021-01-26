package com.fanchen.clearmind.indeed.vo;

import java.util.Stack;

public class PythonValidation {
	public boolean validate(String[] lines) {
		// 就用stack来存之前的line就行
		Stack<String> stack = new Stack<>();
		for (String line : lines) {
			int level = getIndent(line);
			// 先检查是不是第一行
			if (stack.isEmpty()) {
				if (level != 0) {
					System.out.println(line);
					return false;
				}
			}
			// 再检查上一行是不是control statement
			else if (stack.peek().charAt(stack.peek().length() - 1) == ':') {
				if (getIndent(stack.peek()) + 1 != level) {
					System.out.println(line);
					return false;
				}
			} else {
				while (!stack.isEmpty() && getIndent(stack.peek()) > level) {
					stack.pop();
				}
				if (getIndent(stack.peek()) != level) {
					System.out.println(line);
					return false;
				}
			}
			stack.push(line);
		}
		return true;
	}
    //这里如果它说n个空格算一次tab的话，就最后返回的时候res/n好了。
	public int getIndent(String line) {
		int res = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ') {
				res++;
			} else
				break;
		}
		return res;
	}
    public static void main(String[] args) {
    	PythonValidation test = new PythonValidation();
        String[] lines = {
                "def:",
                " abc:",
                "  b2c:",
                "   cc",
                " b5c",
                "b6c"
        };
        System.out.println(test.validate(lines));
        //先这样吧，应该行了。
    }
}
