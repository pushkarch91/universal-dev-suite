void main() {
    System.out.println("This is an instance main method");
    IO.println("Enter name: ");
    String name = IO.readln();
    IO.println("Welcome: " + name);
}

// We can access instance variable inside instance method