package br.com.furb.Excessoes;

public class InvalidFuelException extends IllegalArgumentException {

    public InvalidFuelException(String message) {
        super(message);
    }

}
