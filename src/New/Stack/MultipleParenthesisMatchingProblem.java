package DSAJAVA.Stack;

public class MultipleParenthesisMatchingProblem {

    public static void solution(String string){
        MyStack<Character> list=new MyStack<>();
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)=='(' || string.charAt(i)=='{' || string.charAt(i)=='[')
                list.push(string.charAt(i));
            else if (string.charAt(i)==')'){
                if (list.isEmpty() || list.getTop()!='('){
                    System.out.println("Un-Balanced Expression");
                    return;
                }
                list.pop();
            }
            else if (string.charAt(i)=='}'){
                if (list.isEmpty() || list.getTop()!='{'){
                    System.out.println("Un-Balanced Expression");
                    return;
                }
                list.pop();
            }
            else if (string.charAt(i)==']'){
                if (list.isEmpty() || list.getTop()!='['){
                    System.out.println("Un-Balanced Expression");
                    return;
                }
                list.pop();
            }
        }
        if (!list.isEmpty()){
            System.out.println("Un-Balanced Expression");
            return;
        }
        System.out.println("Balanced Expression");
    }

    public static void main(String[] args) {
        solution("122{21}21[2]");
        solution("{(12323*373))");
        solution("][{(12323*373))]");
    }
}
