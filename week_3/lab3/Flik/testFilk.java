import static org.junit.Assert.*;

import org.junit.Test;


public class testFilk {
    @Test
    public void testIsSameNumber() {
        int a = 128;
        int b = 128;
        int c = 114514;
        assertTrue(Flik.isSameNumber(a, b));
        assertFalse(Flik.isSameNumber(a, c));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", testFilk.class);
    }
}
