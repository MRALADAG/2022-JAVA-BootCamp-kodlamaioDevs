package kodlama.io.Devs.core.utilities.exceptions;

public class SoftwareNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1738255901222435052L;
	private static final String ALERT = "Belirtilen yazılım bulunmamaktadır!";

	public SoftwareNotFoundException() {
	}

	public SoftwareNotFoundException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
