import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.*;

public class TopKElementsTest {

    
    @Test
    public void basicTest() {
        int[] nums = {4, 1, -1, 2,-1, 2, 3};
        TopKElements a = new TopKElements();
        List<Integer> out = a.topKFrequent(nums, 2);
        out.add(1);
    }
}
