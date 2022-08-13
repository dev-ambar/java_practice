package collection;

public class CustomStack {

    private Object [] stack = new Object[5];
    int top = 0;
    public void push(int i) {
        stack[top] = i;
        top ++;
    }
}

class  Runner
{
    public static void main (String [] arg)
    {
        CustomStack stack = new CustomStack();
         stack.push(15);
    }
}
