package org.musala.org.musala.dispactservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientException extends RuntimeException {
	private final String message;

	public static ClientException of(String message) {
		return new ClientException(message);
	}
}