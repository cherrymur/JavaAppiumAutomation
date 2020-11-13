import org.junit.Test;

public class MainTest extends CoreTestCase
{
    MathHelper Math = new MathHelper();

    @Test
    public void myFirstTest()
    {
        int a = Math.multiply( 5);
        System.out.println(a);

        int b = Math.multiply( 5, 2);
        System.out.println(b);
    }
}

