import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassString()
    {
        Assert.assertTrue("getClassString method don't return a string with 'hello' or 'Hello'",
                this.getClassString().toLowerCase().contains("hello"));
    }
}
