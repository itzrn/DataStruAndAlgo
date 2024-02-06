package DSAJAVA.Stack;

public class ParenthesisMatchingProblem {
    public static void solution(String string){
        MyStack<Character> list=new MyStack<>();
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)=='(')
                list.push('(');
            else if (string.charAt(i)==')'){
                if (list.isEmpty()){
                    System.out.println("Unbalanced Expression");
                    return;
                }
                list.pop();
            }
        }
        if (!list.isEmpty()) {
            System.out.println("UnBalanced Expression");
            return;
        }
        System.out.println("Balanced Expression");
    }

    public static void main(String[] args) {
        solution("1*7)+(6*7)");
        solution("(74+94)*84-(76*75)");
    }
}
