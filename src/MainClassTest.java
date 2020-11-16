import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassNumber()
    {
        Assert.assertTrue("getClassNumber method don't return a number more than 45", this.getClassNumber() > 45);
    }
}
