package kodlama.io.Devs.core.utilities.exceptions;

public class SoftwareIdNotEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8127238956911048980L;
	private static final String ALERT = "Yazılımın id bilgisi boş bırakılamaz!";

	public SoftwareIdNotEmptyException() {
	}

	public SoftwareIdNotEmptyException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
