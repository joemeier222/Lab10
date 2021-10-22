package tarleton.lab10;

import java.util.Scanner;

/**
 *
 * @author Joe Meier
 */
public class Main {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            Calculator calc = new Calculator(sc.nextLine());
            System.out.println(Integer.toString(calc.eval()));
    }
}
