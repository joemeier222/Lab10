package tarleton.lab10;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joe Meier
 */
public class CalculatorTest {
    
    @Test
    public void testAdd1() {
        int num = new Calculator("2 3 +").eval();
        assertEquals(5,num);
    }
    
    @Test
    public void testAdd2() {
        int num = new Calculator("2 3 + 4 +").eval();
        assertEquals(9, num);
    }
    
    @Test
    public void testSub1() {
        int num = new Calculator("2 3 -").eval();
        assertEquals(-1, num);
    }
    
    @Test
    public void testSub2() {
        int num = new Calculator("2 3 5 - -").eval();
        assertEquals(4, num);
    }
    
    @Test
    public void testMult1() {
        int num = new Calculator("2 3 *").eval();
        assertEquals(6, num);
    }
    
    @Test
    public void testMult2() {
        int num = new Calculator("-2 3 4 * *").eval();
        assertEquals(-24, num);
    }
    
    @Test
    public void testDiv1() {
        int num = new Calculator("6 3 /").eval();
        assertEquals(2, num);
    }
    
    @Test
    public void testDiv2() {
        int num = new Calculator("-6 -3 / 2 /").eval();
        assertEquals(1, num);
    }

    @Test
    public void testDiv3() {
        CalculatorException e = assertThrows(
        CalculatorException.class, () -> new Calculator("6 0 /").eval());
        assertEquals("Cannot divide by zero.", e.getMessage());
    }
    
    @Test
    public void testEval1() {
        int num = new Calculator("2 3 4 * +").eval();
        assertEquals(14, num);
    }

    @Test
    public void testEval2() {
        int num = new Calculator("2 3 * 4 +").eval();
        assertEquals(10, num);
    }    
}
