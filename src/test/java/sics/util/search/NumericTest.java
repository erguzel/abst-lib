/*
package sics.util.search;

import com.sicsrobotics.util.search.Numeric;
import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NumericTest extends TestCase {


    private static int [] ints ;

    @BeforeClass
    private void initialize(){

        ints = new int[5];
        ints[0] = -8;
        ints[1] = -4;
        ints[2] = 0;
        ints[3] = 4;
        ints[4] = 7;


    }


    @AfterClass
    private void dispose(){

        ints = null;

    }

    @Test
    public void testextremum(){

        int max = Numeric.max(ints);
        int min = Numeric.min(ints);

        Assert.assertTrue(max==7 && min==-8);
    }

    @Test
    public void testSortAsc(){

        int[] res = {-8, -4, 0, 4, 7};

        Assert.assertEquals(res, Numeric.SortAsc(ints));


    }

}*/
