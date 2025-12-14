package l16;

import org.junit.jupiter.api.Test;
import prog2.l16.Stack;
import prog2.l16.StackImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    @Test
    public void pushUndPull(){
        Stack stack = new StackImpl();
        stack.push("apfel");
        stack.push(123);
        stack.push("birne");
        assertEquals("birne",stack.pop());
    }
}
