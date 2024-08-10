package com.kumar.fhn;
public class Connection {
    public void open() {
        // Logic to open the connection
        System.out.println("Connection opened");
    }
    public void close() {
        // Logic to close the connection
        System.out.println("Connection closed");
    }
    public static void main(String[] args) {
        method2();
    }
    private static void method2() {
        Connection connection = new Connection();
        connection.open();
        try {
            // LOGIC
            String str = "Some string value";  // Initialize str properly to avoid NullPointerException
            System.out.println(str.toString());
        } catch (Exception e) {
            // Printing the stack trace is a good practice
            e.printStackTrace();
            System.out.println("Exception Handled - Method 2");
        } finally {
            connection.close();
        }
    }
}


