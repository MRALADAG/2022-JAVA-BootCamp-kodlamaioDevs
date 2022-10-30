package kodlama.io.Devs.core.utilities.exceptions;

public class SoftwareNameNotEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -701893047198299582L;
	private static final String ALERT = "Yazılım ismi boş bırakılamaz!";

	public SoftwareNameNotEmptyException() {
	}

	public SoftwareNameNotEmptyException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
