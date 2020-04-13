package br.com.alessanderleite.app.exception;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3805256569925622715L;

	public NotFoundException(String message) {
		super(message);
	}
}
