import org.junit.Test;

public class MainTest extends CoreTestCase
{
    int a = 5;
    int b = 11;

    @Test
    public void myFirstTest()
    {
        int a = this.multiply( 5);
        System.out.println(a);

        int b = this.multiply( 5, 2);
        System.out.println(b);
    }
}

