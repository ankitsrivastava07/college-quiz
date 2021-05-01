package users.controller;

import lombok.Data;

@Data
public class JwtResponse {

	private String tocken;

	public JwtResponse(String tocken) {
		this.tocken = tocken;
	}

}
