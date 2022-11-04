package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.Devs.business.abstracts.SoftwareService;
import kodlama.io.Devs.core.utilities.CheckValidityForSoftware;
import kodlama.io.Devs.core.utilities.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs.dataAccess.abstracts.SoftwareRepository;
import kodlama.io.Devs.entities.concretes.Software;

@Service
public class SoftwareManager implements SoftwareService {

	@Autowired
	private SoftwareRepository softwareRepository;

	@Autowired
	private CheckValidityForSoftware checkValidityForSoftware;

	private List<Exception> chekList;

	public SoftwareManager() {

	}

	@Override
	public Software addSoftware(Software software) throws Exception {

		chekList = new ArrayList<Exception>();
		chekList.add(checkValidityForSoftware.checkSoftwareId(software));
		chekList.add(checkValidityForSoftware.checkSoftwareName(software));
		chekList.add(checkValidityForSoftware.checkSoftwareNameIsEmptyOrNull(software));
		checkValidityForSoftware.isValid(chekList);

		if (software.getId() == 0)
			software.setId(getAllSoftware().size() + 1);
		return softwareRepository.addSoftware(software);

	}

	@Override
	public Software updateSoftware(Software software) throws Exception {

		chekList = new ArrayList<Exception>();
		chekList.add(checkValidityForSoftware.checkIfId(software.getId()));
		chekList.add(checkValidityForSoftware.checkSoftwareNameIsEmptyOrNull(software));
		checkValidityForSoftware.isValid(chekList);

		return getAllSoftware().stream().map(element -> {
			if (element.getId() == software.getId())
				element.setName(software.getName());
			return element;
		}).filter(item -> item.getId() == software.getId()).findAny().orElseThrow(SoftwareNotFoundException::new);

	}

	@Override
	public Software getSoftwareById(int softwareId) throws Exception {

		chekList = new ArrayList<Exception>();
		chekList.add(checkValidityForSoftware.checkIfId(softwareId));
		chekList.add(checkValidityForSoftware.checkSoftwareById(softwareId));
		checkValidityForSoftware.isValid(chekList);

		return softwareRepository.getSoftwareById(softwareId);

	}

	@Override
	public void deleteSoftwareById(int softwareId) throws Exception {

		chekList = new ArrayList<Exception>();
		chekList.add(checkValidityForSoftware.checkIfId(softwareId));
		chekList.add(checkValidityForSoftware.checkSoftwareById(softwareId));
		checkValidityForSoftware.isValid(chekList);

		softwareRepository.deleteSoftwareById(softwareId);

	}

	@Override
	public List<Software> getAllSoftware() {

		return softwareRepository.getAll();
	}

}
