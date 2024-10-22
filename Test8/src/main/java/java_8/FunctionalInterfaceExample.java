package java_8;

@FunctionalInterface
interface MyFunctionalInterface {
    // Single abstract method
    void perform();


    // Default method
    default void display() {
        System.out.println("Displaying default method in My Functional Interface");
    }

}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Using a lambda expression to implement the functional interface
        MyFunctionalInterface func = () -> System.out.println("Performing action using lambda expression!");

        // Call the abstract method
        func.perform();  // Output: Performing action using lambda expression!

        // Call the default method
        func.display();  // Output: Displaying default method in MyFunctionalInterface
    }
}
