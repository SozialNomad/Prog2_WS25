package prog2.l16;

import java.util.ArrayList;

public class StackImpl<T> implements Stack<T> {

    ArrayList<T> arr = new ArrayList<>();
    public void push(T e) {
        arr.add(e);
    }

    public T pop() {
        return arr.remove(arr.size() - 1);
    }
    public static void main(String[] args) {
        StackImpl<String> s = new StackImpl<>();
        s.push("Hallo");
        s.push("Welt");
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
