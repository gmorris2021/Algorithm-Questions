import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class DiceTest {
    
    @Test
    public void notWorking() {
        int d = 30;
        int f = 30;
        int target = 500;
        Dice a = new Dice();
        int val = a.numRollsToTarget(d, f, target);
        val = val + 1;
    }
}
