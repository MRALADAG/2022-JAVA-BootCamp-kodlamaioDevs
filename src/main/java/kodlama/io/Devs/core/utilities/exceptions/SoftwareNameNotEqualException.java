package kodlama.io.Devs.core.utilities.exceptions;

public class SoftwareNameNotEqualException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3000892665768084609L;
	private static final String ALERT = "Aynı isme sahip yazılım eklenemez!";

	public SoftwareNameNotEqualException() {
	}

	public SoftwareNameNotEqualException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
