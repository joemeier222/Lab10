package tarleton.lab10;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 *
 * @author Joe Meier
 */
public class Calculator {
    private String expr;

    public Calculator(String expr) {
        this.expr = expr;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }
    
    public int eval(){
        String[] tokens = expr.split("\\s+");
        Deque<Integer> nums = new ArrayDeque<>();
        for ( String t : tokens){
            if (t.equals("+") || t.equals("-") || t.equals("/") || t.equals("*")){
                int b = nums.pop();
                int a = nums.pop();
                int c = calc(t, a, b);
                nums.push(c);
            }
            else{
                try {
                int num  = Integer.parseInt(t);
                nums.push(num);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }                       
        }
        return nums.pop();     
    }
    
    public int calc(String op, int a, int b){
        switch(op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0){
                    throw new CalculatorException("Cannot divide by zero.");
                }
                return a / b;
            default:
                throw new AssertionError("Invalid Operator: " + op);
                
        }
    }
}
