import org.junit.Test;

public class MainTest
{
    int a = 5;
    int b = 11;


    @Test
    public void myFirstTest()
    {
        int a = this.giveMeInt();

        if(a > b) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

    public int giveMeInt()
    {
        return 5;
    }
}

