package kodlama.io.Devs.business.abstracts;

import java.util.List;
import kodlama.io.Devs.entities.concretes.Software;

public interface SoftwareService {
	Software addSoftware(Software software) throws Exception;

	Software updateSoftware(Software software) throws Exception;

	Software getSoftwareById(int softwareId) throws Exception;

	void deleteSoftwareById(int softwareId) throws Exception;

	List<Software> getAllSoftware();
}
