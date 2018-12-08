import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Stack;

class ValidParentheses {
	private HashMap<Character, Character> mappings;

	public ValidParentheses() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')','(');
		this.mappings.put('}','{');
		this.mappings.put(']','[');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (this.mappings.containsKey(c)) {
				char top = stack.empty()? '#' : stack.pop();

				if (top != this.mappings.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();
		boolean res = solution.isValid("()[]{}");
		System.out.print(res);
	}
}