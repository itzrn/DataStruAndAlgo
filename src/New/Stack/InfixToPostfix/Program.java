package DSAJAVA.Stack.InfixToPostfix;

public class Program {
    public static String InfixToPostfix(String string){
        InfixToPostfixStack inToPoStack=new InfixToPostfixStack();//---> User Defined Data Structure
        StringBuilder newString= new StringBuilder();
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)=='/'){
                if (inToPoStack.isEmpty() || inToPoStack.topPrecedence()<2)
                    inToPoStack.push('/',2);
                else if (inToPoStack.topPrecedence()>=2){
                    while (inToPoStack.topPrecedence()>=2){
                        newString.append(inToPoStack.topOperator());
                        inToPoStack.pop();
                    }
                    inToPoStack.push('/',2);
                }
            } else if (string.charAt(i)=='*'){
                if (inToPoStack.isEmpty() || inToPoStack.topPrecedence()<2)
                    inToPoStack.push('*',2);
                else if (inToPoStack.topPrecedence()>=2){
                    while (inToPoStack.topPrecedence()>=2){
                        newString.append(inToPoStack.topOperator());
                        inToPoStack.pop();
                    }
                    inToPoStack.push('*',2);
                }
            }else if(string.charAt(i)=='+'){
                if (inToPoStack.isEmpty())
                    inToPoStack.push('+',1);
                else {
                    while (!inToPoStack.isEmpty()) {
                        newString.append(inToPoStack.topOperator());
                        inToPoStack.pop();
                    }
                    inToPoStack.push('+',1);
                }
            }else if(string.charAt(i)=='-'){
                if (inToPoStack.isEmpty())
                    inToPoStack.push('-',1);
                else {
                    while (!inToPoStack.isEmpty()){
                        newString.append(inToPoStack.topOperator());
                        inToPoStack.pop();
                    }
                    inToPoStack.push('-',1);
                }
            }else
                newString.append(string.charAt(i));
        }
        while (!inToPoStack.isEmpty()){
            newString.append(inToPoStack.topOperator());
            inToPoStack.pop();
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        System.out.println(InfixToPostfix("x/z+k"));
        System.out.println(InfixToPostfix("a-b*d+c"));
        System.out.println(InfixToPostfix("x-y/z-k*d"));
        System.out.println(InfixToPostfix("z/w+r-t/h"));
    }
}
