public class MathHelper
{
//    identificator final allow you do not change initial value
    final public int simple_int = 7;
    final public static int static_int = 7;

//    we can use static fields in no static method
    public void changeSimpleInt()
    {
        static_int = 8;
    }

//    we can't use no static fields in static method
    public static void changeSimpleIntByStaticFunction()
    {
        this.simple_int = 8;
    }

    public int calc(int a, int b, char action) {
        if (action == '+') {
            return this.plus(a, b);
        } else if (action == '-') {
            return this.minus(a, b);
        } else if (action == '/') {
            return this.divide(a, b);
        } else if (action == '*') {
            return this.multiply(a, b);
        } else {
            return this.typeAnErrorAndReturnDefaultValue("Wrong action: " + action);
        }
    }

    private int typeAnErrorAndReturnDefaultValue (String error_message) {
        System.out.println(error_message);
        return 0;
    }

    private int plus(int a, int b)
    {
        return a + b;
    }

    private int minus(int a, int b)
    {
        return a - b;
    }

    private int multiply(int a, int b)
    {
        return a * b;
    }

    private int divide(int number, int divider)
    {
        if(divider == 0) {
            return this.typeAnErrorAndReturnDefaultValue("Cannot divide by zero");
        } else {
            return number / divider;
        }
    }
}