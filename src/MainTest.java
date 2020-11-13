import org.junit.Test;

public class MainTest
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
        if(a > b) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }

    public int multiply(int number)
    {
        return number * 5;
    }

    public int multiply(int number, int multiplier)
    {
        return number * multiplier;
    }
}

