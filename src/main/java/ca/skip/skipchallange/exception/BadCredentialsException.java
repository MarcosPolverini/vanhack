package ca.skip.skipchallange.exception;

public class BadCredentialsException extends Exception {

	public BadCredentialsException() {
		super("Invalid user or password");
	}
}
