import org.junit.Test;

public class MainTest
    {
        @Test
        public void myFirstTest()
        {
            int a = 10;
            int b = 15;

            if(a > b) {
                System.out.println("This will never happen");
            } else {
                System.out.println("This is what will happen");
        }
    }
}
