import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
public class BSTTest {

    @Test
    public void basicTest() {
        BST b = new BST();
        int[] a = {8,5,1,7,10,12};
        BST.TreeNode c = b.bstFromPreorder(a);
        assertEquals(c.val, 0);
    }
    
    @Test
    public void barcodesTest() {
        Barcodes b = new Barcodes();
        int[] a = {2,2,2, 1, 5};
        int[] d = b.rearrangeBarcodes(a);
        assertEquals(d, a);
    }
    
}
