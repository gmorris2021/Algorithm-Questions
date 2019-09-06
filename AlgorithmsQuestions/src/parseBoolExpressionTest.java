import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
public class parseBoolExpressionTest {

    @Test
    public void nonBasicTest() {
        parseBoolExpression a = new parseBoolExpression();
        assertFalse(a.parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}
