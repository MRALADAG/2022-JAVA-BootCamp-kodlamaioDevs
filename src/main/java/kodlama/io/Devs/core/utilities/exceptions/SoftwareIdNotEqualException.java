package kodlama.io.Devs.core.utilities.exceptions;

public class SoftwareIdNotEqualException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3541061254280525983L;
	private static final String ALERT = "Aynı id bilgisine sahip yazılım eklenemez!";

	public SoftwareIdNotEqualException() {
	}

	public SoftwareIdNotEqualException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
