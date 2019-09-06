import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
public class ZigZagTreeTest {
   
    @Test
    public void test() {
        ZigZagTree a = new ZigZagTree();
        List<Integer> b = a.pathInZigZagTree(14);
        b.add(0);
    }
    
}
