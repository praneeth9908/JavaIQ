import java.util.function.Predicate;

// Example 1
public class Lambda {
    public static void main(String[] args) {
        // Using a built-in functional interface (Predicate) with a lambda expression
        Predicate<String> startsWithA = (s) -> s.startsWith("A");

        // Test the predicate
        System.out.println("Starts with 'A': " + startsWithA.test("Apple"));
        System.out.println("Starts with 'A': " + startsWithA.test("Banana"));
    }
}

// Example 2

interface MyFunction {
    void myMethod(String s);
}

class Lambda1 {
    public static void main(String[] args) {
        // Implement the functional interface using a lambda expression
        MyFunction myFunction = (s) -> System.out.println("Hello, " + s);

        // Call the method defined in the functional interface
        myFunction.myMethod("World");
    }
}
