package users.controller;

import lombok.Data;

@Data
public class LoginStatus {

	private boolean status;
	private String message;
	private String tocken;
}
