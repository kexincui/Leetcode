import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Stack;

class ValidParentheses {
	private HashMap<Character, Character> mappings; // Hash table that takes care of the mappings

	// Initiazlie hash map with mappings.
    // Constructor
	public ValidParentheses() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')','(');
		this.mappings.put('}','{');
		this.mappings.put(']','[');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>(); // Initialize a stack

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// If the current char is a closing bracket
			if (this.mappings.containsKey(c)) {     
				// get the top element; if stack is empty, set dummy value of '#'
				char top = stack.empty()? '#' : stack.pop();

				// If the mapping for this bracket doesn't match the top element
				if (top != this.mappings.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		// At the end, to see if the stack still contains elements.
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();
		boolean res = solution.isValid("()[]{}");
		System.out.print(res);
	}
}