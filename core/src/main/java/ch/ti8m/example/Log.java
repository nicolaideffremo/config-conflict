package ch.ti8m.example;

public class Log {

    private final String message;

    Log(String message) {
        this.message = message;
    }

    public String run() {
        System.out.println(message);
        return message;
    }
}
