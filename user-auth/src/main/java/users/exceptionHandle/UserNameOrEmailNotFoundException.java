package users.exceptionHandle;

public class UserNameOrEmailNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNameOrEmailNotFoundException(String message) {
		super(message);
	}

}
