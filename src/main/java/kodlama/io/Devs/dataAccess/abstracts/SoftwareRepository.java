package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Software;

public interface SoftwareRepository {
	Software addSoftware(Software software);

	Software updateSoftware(Software software);

	Software getSoftwareById(int softwareId);

	void deleteSoftwareById(int softwareId);

	List<Software> getAll();
}
