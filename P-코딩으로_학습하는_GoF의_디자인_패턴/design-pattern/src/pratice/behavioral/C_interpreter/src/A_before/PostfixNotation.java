package A_before;

import java.util.Stack;

public class PostfixNotation {
    private final String expression;

    public PostfixNotation(String expression) {
        this.expression = expression;
    }

    public static void main(String[] args) {
        PostfixNotation postfixNotation = new PostfixNotation("123+-");
        postfixNotation.calculate();
    }

    /**
     * prefix/infix/postfix
     * 보통 우리가 산수할 때, 1 + 2 + 3 이러한 방식은 infix 라는 표현식이다. 부호가 가운데 들어가는 형태
     * 부호가 오른쪽으로 가면 postfix 표현식이다.
     * 부호가 앞에 오면 prefix 표현식이다.
     *
     * postfix 123+- 뜻은 2+3 연산 후 1-5(5 는 앞에서 2+3 연산 값) 이다.
     */

    private void calculate() {
        Stack<Integer> numbers = new Stack<>();

        for (char c : this.expression.toCharArray()) {
            switch (c) {
                case '+':
                    numbers.push(numbers.pop() + numbers.pop());
                    break;
                case '-':
                    int right = numbers.pop();
                    int left = numbers.pop();
                    numbers.push(left - right);
                    break;
                default:
                    numbers.push(Integer.parseInt(c + ""));
            }
        }
        System.out.println(numbers.pop());
    }
}
