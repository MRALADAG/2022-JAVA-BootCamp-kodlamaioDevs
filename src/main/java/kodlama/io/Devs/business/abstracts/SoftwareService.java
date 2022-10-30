package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs.entities.concretes.Software;

public interface SoftwareService {
	Software addSoftware(Software software)
			throws SoftwareIdNotEqualException, SoftwareNameNotEqualException, SoftwareNameNotEmptyException,
			SoftwareIdNotEmptyException;

	Software updateSoftware(Software software)
			throws SoftwareNotFoundException, SoftwareIdNotEmptyException, SoftwareNameNotEmptyException;

	Software getSoftwareById(int softwareId) throws SoftwareNotFoundException, SoftwareIdNotEmptyException;

	void deleteSoftwareById(int softwareId) throws SoftwareIdNotEmptyException, SoftwareNotFoundException;

	List<Software> getAllSoftware();
}
