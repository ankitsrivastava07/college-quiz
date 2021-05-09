package users.exceptionHandle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import users.controller.LoginStatus;

@ControllerAdvice
public class GlobalExceptionHandle {

	@Autowired
	private HttpServletRequest path;

	@ExceptionHandler(UserNameOrEmailNotFoundException.class)
	public ResponseEntity<?> userNameNotFound(UserNameOrEmailNotFoundException exception) {

		/*
		 * ApiError apiError = new ApiError(new Date(), HttpStatus.OK.value(),
		 * HttpStatus.OK.name(), exception.getMessage(), path.getRequestURI());
		 */
		LoginStatus loginStatus = new LoginStatus();

		loginStatus.setStatus(Boolean.FALSE);
		loginStatus.setMessage(exception.getMessage());

		return new ResponseEntity<>(loginStatus, HttpStatus.OK);
	}

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<?> invalidCredential(InvalidCredentialException exception) {

		LoginStatus loginStatus = new LoginStatus();
		loginStatus.setStatus(Boolean.FALSE);
		loginStatus.setMessage(exception.getMessage());

		return new ResponseEntity<>(loginStatus, HttpStatus.OK);
		// "Invalid uername or password";

	}

	@ExceptionHandler(UserBlockedException.class)
	public ResponseEntity<?> userBlocked(UserBlockedException exception) {

		LoginStatus loginStatus = new LoginStatus();
		loginStatus.setStatus(Boolean.FALSE);
		loginStatus.setMessage(exception.getMessage());

		return new ResponseEntity<>(loginStatus, HttpStatus.OK);
	}

}
