import org.junit.Assert;
import org.junit.Test;

public class MainTest extends CoreTestCase
{
    @Test
    public void myFirstTest()
    {
        this.assertFail();
    }
    private void assertFail()
    {
        Assert.fail("Failed");
    }

}

