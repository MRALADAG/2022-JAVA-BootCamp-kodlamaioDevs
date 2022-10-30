package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SoftwareService;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareIdNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEmptyException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNameNotEqualException;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs.dataAccess.abstracts.SoftwareRepository;
import kodlama.io.Devs.entities.concretes.Software;

@Service
public class SoftwareManager implements SoftwareService {

	@Autowired
	private SoftwareRepository softwareRepository;

	@Override
	public Software addSoftware(Software software)
			throws SoftwareIdNotEqualException, SoftwareNameNotEqualException, SoftwareNameNotEmptyException {
		if (checkSoftwareId(software)) {
			throw new SoftwareIdNotEqualException(software.toString());
		} else if (checkSoftwareNameIsEmptyOrNull(software)) {
			throw new SoftwareNameNotEmptyException(software.toString());
		} else if (checkSoftwareName(software)) {
			throw new SoftwareNameNotEqualException(software.toString());
		}

		if (software.getId() == 0)
			software.setId(getAllSoftware().size() + 1);
		return softwareRepository.addSoftware(software);

	}

	@Override
	public Software updateSoftware(Software software)
			throws SoftwareNotFoundException, SoftwareIdNotEmptyException, SoftwareNameNotEmptyException {

		if (software.getId() == 0) {
			throw new SoftwareIdNotEmptyException(software.toString());
		} else if (checkSoftwareNameIsEmptyOrNull(software)) {
			throw new SoftwareNameNotEmptyException();
		} else {
			return getAllSoftware().stream().map(element -> {
				if (element.getId() == software.getId())
					element.setName(software.getName());
				return element;
			}).filter(item -> item.getId() == software.getId()).findAny().orElseThrow(SoftwareNotFoundException::new);
		}

	}

	@Override
	public Software getSoftwareById(int softwareId) throws SoftwareNotFoundException, SoftwareIdNotEmptyException {

		if (softwareId == 0) {
			throw new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId));
		} else if (!checkSoftwareById(softwareId)) {
			throw new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));
		} else
			return softwareRepository.getSoftwareById(softwareId);

	}

	@Override
	public void deleteSoftwareById(int softwareId) throws SoftwareIdNotEmptyException, SoftwareNotFoundException {
		if (softwareId == 0) {
			throw new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId));
		} else if (!checkSoftwareById(softwareId)) {
			throw new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));
		}

		softwareRepository.deleteSoftwareById(softwareId);

	}

	@Override
	public List<Software> getAllSoftware() {

		return softwareRepository.getAll();
	}

	private boolean checkSoftwareId(Software software) {
		List<Software> softwares = getAllSoftware();
		boolean result = softwares.stream().anyMatch(item -> item.getId() == software.getId());
		return result;
	}

	private boolean checkSoftwareById(int softwareId) {
		List<Software> softwares = getAllSoftware();
		boolean result = softwares.stream().anyMatch(item -> item.getId() == softwareId);
		return result;
	}

	private boolean checkSoftwareName(Software software) {
		List<Software> softwares = getAllSoftware();
		boolean result = softwares.stream().anyMatch(item -> item.getName().equalsIgnoreCase(software.getName()));
		return result;
	}

	private boolean checkSoftwareNameIsEmptyOrNull(Software software) {
		return (software.getName() == null || software.getName().isBlank() || software.getName().isEmpty()) ? true
				: false;
	}
}
