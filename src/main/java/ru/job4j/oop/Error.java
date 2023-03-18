package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);
    }

    public static void main(String[] args) {
        Error error0 = new Error();
        error0.printInfo();
        Error error404 = new Error(true, 404, "Not Found");
        error404.printInfo();
        Error error502 = new Error(true, 502, "Bad Gateway");
        error502.printInfo();
        Error error400 = new Error(true, 400, "Bad Request");
        error400.printInfo();
    }
}
