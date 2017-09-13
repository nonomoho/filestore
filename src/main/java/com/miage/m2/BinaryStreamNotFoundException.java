package com.miage.m2;

public class BinaryStreamNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public BinaryStreamNotFoundException() {
		super();
	}

	public BinaryStreamNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BinaryStreamNotFoundException(String message) {
		super(message);
	}

	public BinaryStreamNotFoundException(Throwable cause) {
		super(cause);
	}

}
