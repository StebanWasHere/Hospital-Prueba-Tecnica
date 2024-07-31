package Exceptions;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String mensaje) {
        super(mensaje);
    }
}
