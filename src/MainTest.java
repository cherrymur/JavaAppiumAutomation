import org.junit.Assert;
import org.junit.Test;

public class MainTest extends CoreTestCase
{
    @Test
    public void myFirstTest()
    {
        int expected = 25;
        int actual = 5 * 5;

        Assert.assertTrue("Failed", actual == expected);
    }

}

