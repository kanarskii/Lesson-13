package Task1;

public class WrongLoginException extends Exception{
    private String message;

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "login не удовлетворяет условиям";
    }
}
